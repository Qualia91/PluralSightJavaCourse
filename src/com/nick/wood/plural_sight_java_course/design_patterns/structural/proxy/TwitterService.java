package com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy;

/** this is the interface subject that the client asks for
 *
 */
public interface TwitterService {

	public String getTimeline(String screenName);
	public void postTimeline(String screenName, String message);

}
