package com.nick.wood.plural_sight_java_course.design_patterns.structural.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbFacade {

	DbSingleton instance = null;

	public DbFacade() {
		instance = DbSingleton.getInstance();
	}

	public int createTable() {

		int count = 0;

		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	public int insertIntoTable() {

		int count = 0;

		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			count = sta.executeUpdate("INSERT INTO Address (ID, StreetName, City) values (1, '1234 Some Street', 'Layton')");
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	public List<Address> getAddresses() {

		List<Address> addresses = new ArrayList<>();

		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM Address");

			while (rs.next()) {

				addresses.add(new Address(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3)
				));

			}

			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return addresses;
	}

}
