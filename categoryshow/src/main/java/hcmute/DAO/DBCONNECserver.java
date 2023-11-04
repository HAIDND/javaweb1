package hcmute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCONNECserver {
	private final String serverName = "MSI\\SQLEXPRESS";
	private final String dbName = "mvcservletweb2023";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "sa";
	private final String password = "123qwe";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBCONNECserver().getConnection());
			int a = 1;
			if (a == 1) {
				System.out.print("connec thanh cong");

			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}