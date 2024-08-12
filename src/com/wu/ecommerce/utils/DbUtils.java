package com.wu.ecommerce.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {

	private DbUtils() {

	}

	private static DbUtils dbUtils;

	public static DbUtils getInstance() {
		if (dbUtils == null) {
			dbUtils = new DbUtils();
		}
		return dbUtils;
	}

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = loadProperties();

		String url = properties.getProperty("jdbc.url");
		String user = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		System.out.println("Connecting to URL: " + url);
		System.out.println("Using User: " + user);

		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Properties loadProperties() {
		Properties properties = new Properties();
		try (InputStream inputStream = DbUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
			if (inputStream == null) {
				System.out.println("Properties file not found.");
				return properties;
			}
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("Exception caught while loading properties: " + e.getMessage());
		}
		return properties;
	}

	public static void main(String[] args) {
		Properties properties = getInstance().loadProperties();
		System.out.println(properties);
		Connection connection;
		try {
			connection = getInstance().getConnection();
			System.out.println("Connection successful: " + (connection != null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}