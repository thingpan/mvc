package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static final  String driverName = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://localhost:3306/kd";
	private static final String user = "root";
	private static final String pwd = "kd1824java";
	static {
		try {
			Class.forName(driverName);
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		try {
			return DriverManager.getConnection(url,user,pwd);
		}catch(SQLException e) {
		}
		return null;
		
	}
	public static void main(String[] args) {
		Connection con =getCon();
		System.out.println(con);
	}
}
