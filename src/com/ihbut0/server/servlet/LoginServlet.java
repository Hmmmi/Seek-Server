package com.ihbut0.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ihbut0.server.bean.User;
import com.ihbut0.server.dao.UserDAO;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		out.println("Login GET Method");
		
//		String id = request.getParameter("phone");
//		String pass = request.getParameter("password");
//
//		if (UserDAO.verify(id, pass)) {
//			User user = UserDAO.getUser(id);
//			String json = new Gson().toJson(user);
//			out.print(json);
//		} else {
//			out.print("LoginFail");
//		}

		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 1
		response.setContentType("text/html;charset=utf-8"); // 2
		response.setCharacterEncoding("utf-8"); // 3
		PrintWriter out = response.getWriter();

		String id = request.getParameter("phone");
		String pass = request.getParameter("password");

		if (UserDAO.verify(id, pass)) {
			User user = UserDAO.getUser(id);
			String json = new Gson().toJson(user);
//			System.out.println(json);
			out.print(json);
		} else {
			out.print("LoginFail");
		}
		out.close();
	}

}