/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerUser;

import javaapplication2.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author imran
 */
public class UserTable {
    public static void insert(String username, String email, String fn, String ln, String password, String phone, String gender, String address){
        Connection connect= DB.getConnection();
        String sql ="INSERT INTO user (userName, userEmail, firstName, lastName, password, phone, gender, address) VALUES" +"("+ "'"
                +username+"',"
                +"'"+email
                +"','"+fn+"','"+ln+"','"+password+"','"+phone+"','"+gender+"','"+address
                +"')";
        
        
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " +username + " inserted");
            connect.close();
        } catch (Exception ex) {
            System.out.println("[User Table] - error while inserting into userTable"+ex.getMessage());
        }
    
    }
 public static ResultSet get(String email){
        Connection connect= DB.getConnection();
        
        String sql ="SELECT * FROM user WHERE userEmail= '"+email+"'";
        
        ResultSet result =null;
        try {
            Statement statement = connect.createStatement();
            result = statement.executeQuery(sql);
            connect.close();
            
            
        } catch (Exception ex) {
            System.out.println("[User Table] - error while getting from user table "+ex.getMessage());
        }
    
    return result;
}
}
