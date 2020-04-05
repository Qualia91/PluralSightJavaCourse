package com.nick.wood.plural_sight_java_course.http_client;

import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class EchoListener implements WebSocket.Listener {

	private final CountDownLatch receiveLatch;

	public EchoListener(CountDownLatch receiveLatch) {
		this.receiveLatch = receiveLatch;
	}

	@Override
	public void onOpen(WebSocket webSocket) {
		System.out.println("Websocket open");
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.out.println("OnText: " + data);
		receiveLatch.countDown();
		return null;
	}

	@Override
	public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
		System.out.println("onBinary: " + data);
		return null;
	}

	@Override
	public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
		System.out.println("onPing");
		return null;
	}

	@Override
	public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
		System.out.println("onPong");
		return null;
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.out.println("onClose: " + statusCode);
		return null;
	}

	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		System.out.println("onError: " + error.getMessage());
	}
}
