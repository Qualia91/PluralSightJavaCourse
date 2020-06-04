package com.nick.wood.java_learning.security;

import java.io.IOException;

public class DataService {

	DataAccess access;

	public DataService(DataAccess access) {
		this.access = access;
	}

	public void write(String s) throws IOException {
		access.write(s);
	}
}
