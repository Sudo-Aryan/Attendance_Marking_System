package com.admin.attendance.details;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;


@WebServlet("/admin_mark")
public class MarkAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MarkAttendance() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roll_no = Integer.parseInt(request.getParameter("roll_no"));
		String attendanceStatus = request.getParameter("mark_attend");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		
		if(isNotMarked(roll_no,attendanceStatus, date)) {
			response.sendRedirect("show_attendance");
		} else {
			response.sendRedirect("admin_markattendance.html");
		}
	}


	private boolean isNotMarked(int roll_no, String attendanceStatus, LocalDate date) {
		Connection conn = DBConnection.connect();
		
		try {
			
			String sql = "insert into attendance_details(roll_no, attendance, date) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roll_no);
			pstmt.setString(2, attendanceStatus);
			pstmt.setDate(3, Date.valueOf(date));
			
			pstmt.execute();
			
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
