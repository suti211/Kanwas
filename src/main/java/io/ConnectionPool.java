package io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	int max = 10;
	int nextConnection = 0;
	List<Connection> connections = new ArrayList<>();
	
	private static ConnectionPool INSTANCE;
	private ConnectionPool()  {};
	public static ConnectionPool newInstance() {
		if (INSTANCE == null) 
		{
			INSTANCE = new ConnectionPool();
		}
		
		return INSTANCE;
	}
	

	public Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String unicode = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.150.32/kanwas"+unicode, "ferenc", "ferenc");
			connections.add(connection);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	return null;	
	}
	
	public void disconnect(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {	
		if (needConnection()) {
			nextConnection = connections.size() - 1;
			return createConnection();
		}
		
		Connection c = connections.get(nextConnection);
		nextConnection = (nextConnection + 1) % connections.size();
		
		return c;
	}
	
	private boolean needConnection(){
		
		return connections.size() < max;
	}
}
