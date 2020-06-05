package com.nick.wood.java_learning.design_patterns.structural.proxy;

/** this is the interface subject that the client asks for
 *
 */
public interface TwitterService {

	public String getTimeline(String screenName);
	public void postTimeline(String screenName, String message);

}
