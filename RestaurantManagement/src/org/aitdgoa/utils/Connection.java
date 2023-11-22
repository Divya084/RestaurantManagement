
package org.aitdgoa.utils;

import java.sql.*;

public class Connection 
{
    static String URL;
    static java.sql.Connection connection;
    static Statement statement;
    
    public static void setDatabaseConnection()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            URL = "jdbc:mysql://localhost:3306/restaurent";
            connection = DriverManager.getConnection(URL,"root","");
            statement = connection.createStatement();
            System.out.println("Connection successfull");
        } 
        catch (Exception e) 
        {
            System.out.println("Connection unsuccessfull");
        }
    }
}

