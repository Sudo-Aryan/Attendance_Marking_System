package com.student_attendance.details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student_login")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentLogin() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("student_markattendance.html");
	}

}
