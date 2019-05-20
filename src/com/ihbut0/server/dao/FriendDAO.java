package com.ihbut0.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihbut0.server.bean.Friend;
import com.ihbut0.server.utils.ConnectSQL;

public class FriendDAO {

	public static List<Friend> getFriends(String userId) {
		List<Friend> friends = new ArrayList<Friend>();
		Connection conn = ConnectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = conn.
					prepareStatement("SELECT * FROM seek_friend WHERE userID =? OR  friendID =? ");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.last();
			rs.beforeFirst();
			
			while (rs.next()) {
				Friend friend = null;
				String friendAccount;
				String friendLabel;
				
				String id1 = rs.getString("userID");
				if ( id1.equals(userId) ){
					friendAccount = rs.getString("friendID");
					friendLabel = rs.getString("friendLabel");
				} else {
					friendAccount = rs.getString("userID");
					friendLabel = rs.getString("userLabel");
				}
				friend = new Friend(friendAccount,friendLabel,(float)rs.getDouble("matchIndex"));
				friend.setAddTime(rs.getString("addTime"));
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return friends;
	}
	
}
