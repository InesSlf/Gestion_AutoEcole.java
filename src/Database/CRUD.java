/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Connect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msii
 */
public class CRUD {

    Connection conn = new Connect().connect();

    public boolean register(String username, String password, String email, String phoneNumber) {
        try {
            Statement stmt = conn.createStatement();
            String query = "insert into register (user_name, password, email, phone_number) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkUser(String username, String password) {
        PreparedStatement ps;//envoie la requete
        ResultSet rs;//recupere les infos 
        String query = "select *from register where user_name=?and password =?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
