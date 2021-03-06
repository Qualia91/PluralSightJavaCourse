package com.nick.wood.java_learning.security;

import java.io.FileWriter;
import java.io.IOException;

public class DataAccess {

	private String fileName;

	public DataAccess(String fileName) {
		this.fileName = fileName;
	}

	public void write(String s) throws IOException {
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write(s);
		}
	}
}
