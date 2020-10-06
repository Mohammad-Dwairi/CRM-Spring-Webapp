package com.mdwairy.crm;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBCConnection {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC",
                    "** DB Username **",
                    "** Password **"
            );
            System.out.println("Connected Successfully");
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
