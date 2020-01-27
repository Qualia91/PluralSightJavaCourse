package com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy;

import com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.movie_printer_example.StringBuilderPlus;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class TwitterServiceImpl /* implements TwitterService*/ {

	// you will need to use your own here im afraid
	private static final String TWITTER_CONSUMER_KEY = "";
	private static final String TWITTER_SECRET_KEY = "";
	private static final String TWITTER_ACCESS_TOKEN = "";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "";

	@Override
	public String getTimeline(String screenName) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
				.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();
		StringBuilderPlus stringBuilderPlus = new StringBuilderPlus();

		try {
			Query query = new Query(screenName);
			QueryResult queryResult;

			do {
				queryResult = twitter.search(query);
				List<Status> tweets = queryResult.getTweets();

				for (Status tweet : tweets) {
					stringBuilderPlus.appendLine("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}

			} while ((query = queryResult.nextQuery()) != null);

		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return stringBuilderPlus.toString();
	}

	@Override
	public void postTimeline(String screenName, String message) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
				.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();

		try {

			twitter.updateStatus(message);

		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

}
