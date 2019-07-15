package com.ihbut0.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihbut0.server.bean.Friend;
import com.ihbut0.server.bean.User;
import com.ihbut0.server.utils.ConnectSQL;

public class FriendDAO {

	public static List<Friend> getFriends(String userId) {
		List<Friend> friends = new ArrayList<Friend>();
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("SELECT * FROM seek_friend WHERE userID =?");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.last();
			rs.beforeFirst();
			
			while (rs.next()) {
				Friend friend = null;
				String friendAccount = rs.getString("friendID");
				String friendLabel = rs.getString("friendLabel");
				User user = UserDAO.getUser(friendAccount);
				
				friend = new Friend();
				friend.setAccount(friendAccount);
				friend.setAccount(user.getAccount());
				friend.setNickname(user.getNickname());
				friend.setAddress(user.getAddress());
				friend.setBirthday(user.getBirthday());
				friend.setEducation(user.getEducation());
				friend.setHeadImg(user.getHeadImg());
				friend.setBackground(user.getBackground());
				friend.setSex(user.getSex());
				friend.setSign(user.getSign());
				friend.setLabel(friendLabel);
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return friends;
	}
	
}
