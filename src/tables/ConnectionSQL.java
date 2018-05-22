package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSQL {
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/QLS?autoReconnect=true&useSSL=false";

	static final String USER = "root";
	static final String PASS = "kannakamui";
	
	public ConnectionSQL() {
		sysConnect();
	}
	
	public void sysConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USER , PASS);
			st = (Statement) con.createStatement();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
