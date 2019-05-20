package com.ihbut0.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ihbut0.server.bean.Interest;
import com.ihbut0.server.utils.ConnectSQL;

public class InterestDAO {

	public static List<Interest> getInterests(String userId) {
		List<Interest> interests = new ArrayList<Interest>();
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("SELECT * FROM seek_intent WHERE userID = ? ");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Interest interest = new Interest(rs.getString("intentID"), rs.getString("intentCtx"));
				interests.add(interest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return interests;
	}
	
	public static boolean saveInterest(String userId, String InterestCipher) {
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("INSERT INTO seek_intent VALUES (?,?,?) ");
			preparedStatement.setString(1, ""+UUID.randomUUID());
			preparedStatement.setString(2, userId);
			preparedStatement.setString(3, InterestCipher);
			
			int rs = preparedStatement.executeUpdate();
			if ( rs == 1 ){
				System.out.println("兴趣添加成功");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("兴趣添加失败");
		}
		
		return false;
	}
	
}
