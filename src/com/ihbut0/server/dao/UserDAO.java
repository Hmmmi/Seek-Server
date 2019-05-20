package com.ihbut0.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ihbut0.server.bean.User;
import com.ihbut0.server.utils.ConnectSQL;



public class UserDAO {

//	private static Connection connection;

//	public void addUser(User user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("insert into seek_user(userID,password,headImg,background,"
//							+ "sign,nickname,birthday,sex,addressID,education) "
//							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//			// Parameters start with 1
//			preparedStatement.setString(1, user.getUserid());
//			preparedStatement.setString(2, user.getPassword());
//			preparedStatement.setString(3, user.getHeadImg());
//			preparedStatement.setString(4, user.getBackground());
//			preparedStatement.setString(5, user.getSign());
//			preparedStatement.setString(6, user.getNickName());
//			preparedStatement.setString(7, user.getBirthday());
//			preparedStatement.setInt(8, user.getSex());
//			preparedStatement.setString(9, user.getAddress());
//			preparedStatement.setString(10, user.getEdu());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void deleteUser(String userId) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("delete from seek_user where userID=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, userId);
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void updateUser(User user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update users set phone=?, password?" +
//							"where userid=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, user.getPhone());
//			preparedStatement.setString(2, user.getPassword());
//			preparedStatement.setString(3, user.getUserid());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	public List<User> getAllUsers() {
//		List<User> users = new ArrayList<User>();
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from seek_user");
//			while (rs.next()) {
//				User user = new User();
//				user.setUserid(rs.getString("userid"));
//				user.setPassword(rs.getString("password"));
//				user.setHeadImg(rs.getString("headImg"));
//				user.setBackground(rs.getString("background"));
//				user.setSign(rs.getString("sign"));
//				user.setNickName(rs.getString("nickname"));
//				user.setBirthday(rs.getString("birthday"));
//				user.setSex(rs.getInt("sex"));
//				user.setAddress(rs.getString("addressID"));
//				user.setEdu(rs.getString("education"));
//				users.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return users;
//	}
//	
	public static User getUser(String userId) {
		User user = null;
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("select * from seek_user where userID=?");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setAccount(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setHeadImg(rs.getString("headImg"));
				user.setBackground(rs.getString("background"));
				user.setSign(rs.getString("sign"));
				user.setNickname(rs.getString("nickname"));
				user.setBirthday(rs.getString("birthday"));
				user.setSex(rs.getInt("sex"));
				user.setAddress(rs.getString("addressID"));
				user.setEducation(rs.getString("education"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public static boolean verify(String id, String password) {
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("select * from seek_user where userID=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if ( rs.next() ){
				if ( password.equals(rs.getString("password")) ){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
