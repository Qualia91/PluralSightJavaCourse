package com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** this is a proxy
 *
 * It needs to implement InvocationHandler to get that invoke method.
 * it is also a little factory pattern for the proxy object.
 */

public class SecurityProxy implements InvocationHandler {

	private Object obj;

	private SecurityProxy(Object obj) {
		this.obj = obj;
	}

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(
				obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(),
				new SecurityProxy(obj)
		);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Poxy running");

		if (method.getName().contains("post")) {
			throw new IllegalAccessException("Posts are currently not allowed");
		}

		return method.invoke(obj, args);

	}
}
