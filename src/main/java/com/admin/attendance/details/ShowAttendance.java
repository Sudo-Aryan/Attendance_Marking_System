package com.admin.attendance.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;


@WebServlet("/show_attendance")
public class ShowAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DBConnection.connect();
			
			String sql = "select * from attendance_details";
			Statement stmt = conn.createStatement();
			
			ResultSet set = stmt.executeQuery(sql);
			
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Attendance Details</title>");
		    out.println("<style>");
		    
		    out.println(".one {");
		    out.println("display: flex;");
		    out.println("justify-content: center;");
		    out.println("padding: 5rem;");
		    out.println("}");
		    
		    out.println("table {");
		    out.println("  border-collapse: collapse;");
		    out.println("  width: 100%;");
		    out.println("}");

		    out.println("th, td {");
		    out.println("  border: 1px solid black;");
		    out.println("  padding: 10px;");
		    out.println("  text-align: center;");
		    out.println("}");

		    out.println("th {");
		    out.println("  background-color: #dddddd;");
		    out.println("}");

		    out.println("td {");
		    out.println("  text-align: left;");
		    out.println("}");
		    out.println("</style>");
		    out.println("</head>");

		    out.println("<body>");
		    out.println("<div class='one'>");
	        out.println("<table>");
	        out.println("<tr><th>Roll</th><th>Status</th><th>Date</th></tr>");
	        while (set.next()) {
	            out.println("<tr>");
	            out.println("<td>" + set.getString("roll_no") + "</td>");
	            out.println("<td>" + set.getString("attendance") + "</td>");
	            out.println("<td>" + set.getString("date") + "</td>");
	            out.println("</tr>");
	        }
	        out.println("</table>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
			
		} catch(NullPointerException | SQLException e) {
			e.printStackTrace();
		}
	}

}
