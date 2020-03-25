/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author myaduncan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
public class ConnectionOfDatabase {
   
 public static Connection getConnection(){
     Connection conn=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
     }
     catch(ClassNotFoundException e)
     {
         System.out.println("No JDBC Driver found.");
     }
     try
     {
       conn=DriverManager.getConnection("jdbc:mysql://localhost/school_work","jerrodg","HunGryL!0ns");
     }catch (SQLException e)
     {
         System.out.println("Connection failure.");
     }
     return conn;
     
 }
}
