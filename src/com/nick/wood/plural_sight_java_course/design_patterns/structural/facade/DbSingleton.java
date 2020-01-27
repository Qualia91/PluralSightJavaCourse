package com.nick.wood.plural_sight_java_course.design_patterns.structural.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	private static volatile DbSingleton DbSingleton = null;
	private static volatile Connection conn = null;

	private DbSingleton() {
/*
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (conn != null) {
			throw new RuntimeException("Use getConnection() method to create.");
		}

		if (DbSingleton != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
		*/
	}

	public static DbSingleton getInstance() {
		if (DbSingleton == null) {
			synchronized (DbSingleton.class) {
				if (DbSingleton == null) {
					DbSingleton = new DbSingleton();
				}
			}
		}
		return DbSingleton;
	}

	public Connection getConnection() {
		if (conn == null) {
			synchronized (DbSingleton.class) {
				if (conn == null) {
					try {
						conn = DriverManager.getConnection("jdbc:derby:memory:codejava/webdb;create=true");
						System.out.println();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		try {
			if (conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:derby:memory:codejava/webdb;create=true");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
