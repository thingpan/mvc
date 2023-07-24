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

import common.DBCon;

public class ClassInfoRepository {
	public List<Map<String, String>> selectedClassInfoList() {

		List<Map<String, String>> classInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM class_info1 WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(classInfo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfoList;
	}

	public Map<String, String> selectclassInfo(String ciNum) {

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM class_info1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ciNum);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				return classInfo;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insertClassInfo(Map<String, String> classInfo) {
		String sql = "INSERT INTO class_info1(CI_NAME,CI_DESC)";
		sql += "VALUES(?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, classInfo.get("ciName"));
			ps.setString(2, classInfo.get("ciDesc"));
			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public int updateClassInfo(Map<String, String> classInfo) {
		String sql = "UPDATE class_info1";
		sql += "SET UI_NAME=?,";
		sql += "SET UI_DESC=?,";
		sql += "WHERE CI_NUM=?,";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, classInfo.get("ciName"));
			ps.setString(2, classInfo.get("ciDesc"));
			ps.setString(3, classInfo.get("ciNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public int deleteClassInfo(String ciNum) {
		String sql = "DELETE FROM class_info1 WHERE CI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ciNum);
			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

//pageContext
	// request
	// session
	// application
}