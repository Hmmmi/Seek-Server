package com.ihbut0.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ihbut0.server.bean.Friend;
import com.ihbut0.server.dao.FriendDAO;

public class FriendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		out.println("getFriend GET Method");
		
//		String id = request.getParameter("phone");
//		
//		List<Friend> friends = FriendDAO.getFriends(id);
//		Gson gson = new Gson();
//		String jsonFriends = gson.toJson(friends);
//		out.println(jsonFriends);
		
		out.close();
	}

	/**
	 * The doPost method of the servlet. 
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("phone");
		
		List<Friend> friends = FriendDAO.getFriends(id);

		Gson gson = new Gson();
		String jsonFriends = gson.toJson(friends);
		out.println(jsonFriends);
		
		out.close();
	}

}
