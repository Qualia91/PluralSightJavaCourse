package com.nick.wood.java_learning.http_client;


import java.io.File;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;

public class Main {

    private static HttpClient httpClient;

    public static void main(String[] args) throws Exception {

        webSocket();

    }

    private static void webSocket() throws InterruptedException {

        int msgCount = 5;
        CountDownLatch receiveLatch = new CountDownLatch(msgCount);

        CompletableFuture<WebSocket> ws = HttpClient.newHttpClient()
                .newWebSocketBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .buildAsync(URI.create("ws://echo.websocket.org"), new EchoListener(receiveLatch));

        ws.thenAccept(webSocket -> {
            webSocket.request(msgCount);
            for (int i = 0; i < msgCount; i++) {
                webSocket.sendText("Message " + i, true);
            }
        });


        ws.thenAccept(webSocket -> webSocket.sendClose(3, "Test"));
        receiveLatch.await();

    }

    /** Cookies
     *
     */
    private static void cookieManager() throws IOException, InterruptedException {

        // null as first parameter stores cookie in memory and so cookie manager wont be persistent across different runs
        CookieManager cm = new CookieManager(null,
                CookiePolicy.ACCEPT_ALL);

        // use cm as cookie manager
        HttpClient client = HttpClient.newBuilder().cookieHandler(cm).build();

        // will return nothing as no cookie manager has been sent to server and nothing has been sent back
        System.out.println( cm.getCookieStore().getCookies() );

        client.send(
                HttpRequest.newBuilder(URI.create("https://www.google.com")).build(),
                HttpResponse.BodyHandlers.discarding());

        System.out.println( cm.getCookieStore().getURIs() );

        // now we get cookies as we sent cookie manager to google and google sent it back
        System.out.println( cm.getCookieStore().getCookies() );
    }

    /** custom client
     *
     */
    public static void customClient() {

        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        try {
            Files.lines(Path.of("src\\com\\nick\\wood\\plural_sight_java_course\\http_client\\urls.url_txt"))
                    .map(Main::validateLinkAsyncTimeout)
                    .collect(Collectors.toList())
                    .stream()
                    .map(CompletableFuture::join)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** sync and async requests
     *
     */
    private static CompletableFuture<String> validateLinkAsyncTimeout(String link) {

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(link))
                .GET()
                .timeout(Duration.ofSeconds(2))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.discarding())
                .thenApply(Main::responseToString)
                .exceptionally(e -> link + ": " + false);
    }

    private static Optional<String> validateLinkSync(String link) {

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(link))
                .GET()
                .build();

        Optional<String> returnString;

        try {
            HttpResponse<Void> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());
            returnString = Optional.of(responseToString(response));
        } catch (IOException | InterruptedException e) {
            returnString = Optional.of(link + ": " + false);
        }

        return returnString;
    }

    private static CompletableFuture<String> validateLinkAsync(String link) {

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(link))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.discarding())
                .thenApply(Main::responseToString)
                .exceptionally(e -> link + ": " + false);
    }

    private static String responseToString(HttpResponse<Void> response) {

        int status = response.statusCode();
        boolean success = 200 <= status && status <= 299;
        return response.uri().toString() + ": " + success + ": " + status;

    }

    public static void synchronousRequest() {

        httpClient = HttpClient.newHttpClient();

        try {
            Files.lines(Path.of("src\\com\\nick\\wood\\plural_sight_java_course\\http_client\\urls.url_txt"))
                    .map(Main::validateLinkSync)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void asynchronousRequest() {

        httpClient = HttpClient.newHttpClient();

        try {
            Files.lines(Path.of("src\\com\\nick\\wood\\plural_sight_java_course\\http_client\\urls.url_txt"))
                    .map(Main::validateLinkAsync)
                    .collect(Collectors.toList())
                    .stream()
                    .map(CompletableFuture::join)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** body handlers
     *
     */
    public static void bodyHandlers() {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.google.com")).build();

        try {
            HttpResponse<String> responseString = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String bodyString = responseString.body();

            HttpResponse<byte[]> responseByteArray = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            byte[] bodyByteArray = responseByteArray.body();

            HttpResponse<Path> responsePath = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofFile(new File("src\\com\\nick\\wood\\plural_sight_java_course\\http_client\\googleResponsePathTypeFile.txt").toPath()));
            Path bodyPath = responsePath.body();

            HttpResponse<Stream<String>> responseStream = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofLines());
            Stream<String> bodyStream = responseStream.body();

            HttpResponse<Void> responseDiscard = httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());
            Void bodyVoid = responseDiscard.body();

            System.out.println();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    /** old way to do it
     *
     */
    public static void oldWayOfHttpRequests() {

        // this does same as simplestHttpClient() but using old api
        try {

            URL url = new URL("https://www.google.com");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Java 1.1");

            if (con.getResponseCode() == 200) {
                System.out.println(con.getInputStream());
            } else {
                System.out.println("Error");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** basic http client
     *
     */
    public static void simplestHttpClient() {

        // static constructor that creates client with default options
        HttpClient httpClient = HttpClient.newHttpClient();

        // try to retrieve google site
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.google.com")).build();

        try {
            // body handler takes byte response from server (google) and handles it in some way. Here it just
            // turns it into a HttpResponse containing the object you passed to handler (String here) and some extra
            // methods. looked at in detail later.
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
