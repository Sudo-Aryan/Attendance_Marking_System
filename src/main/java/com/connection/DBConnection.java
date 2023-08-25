package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection conn;
    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String url = "jdbc:mysql://localhost:3306/student_attendance";
            String pass = "root";

            conn = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Class not found");
            e.printStackTrace();
        }
        return conn;
    }
}