package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/jee5a";
		String username="sql6587673";
		String password="rAhpFRQqfd";
		Connection con;
		PreparedStatement psmt;
		PrintWriter out=arg1.getWriter();
		String sql="insert into `details`(`name`,`password`,`email`)values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			psmt=con.prepareStatement(sql);
			psmt.setString(1, arg0.getParameter("name"));
			psmt.setString(2, arg0.getParameter("password"));
			psmt.setString(3, arg0.getParameter("email"));
			int n=psmt.executeUpdate();
			if(n>0) {
				out.print("Inserted Successfully");
				
			}
			else {
				out.print("insertion failed");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
