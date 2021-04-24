/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerUser;

import javaapplication2.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imran
 */
public class DB {
    public static Connection getConnection(){
        String urlSQLite= "jdbc:sqlite:company.db";
        
        try{
            //load up sqlite driver
            Driver driverSQLite= new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("sqlite driver loaded up");
        
        }catch(Exception e){
        
            System.out.println("there's an error with the sqlite driver: " + e.getMessage());
            System.out.println("connected to the database");
        }
        Connection connection= null;
        try {
            //establic connection with the database using urlsqlite name
            connection = DriverManager.getConnection(urlSQLite);
            
        } catch (Exception e) {
            System.out.println("there was a problem with establishing the connection " +e.getMessage());
        }
        return connection;
    }
    
}
