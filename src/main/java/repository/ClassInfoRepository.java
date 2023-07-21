package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassInfoRepository {
	public List<Map<String, String>> selectedClassInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String,String>>classInfoList =new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM class_info1 WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("ciNum",rs.getString("CI_NUM"));
				classInfo.put("ciName",rs.getString("CI_NAME"));
				classInfo.put("ciDesc",rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfoList;
	}

	public static void main(String[] args) {
		ClassInfoRepository cl = new ClassInfoRepository();
		cl.selectedClassInfoList();

	}
//pageContext
	//request
	//session
	//application
}