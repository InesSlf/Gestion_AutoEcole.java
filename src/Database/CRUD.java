/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

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
    public boolean addCondidate (String nameC,String FirstName,String DateB,String age ,String phone,String gender ,String bloodType,String adress,String identityNum ){
        PreparedStatement ps;
        String query ="insert into condidate (name,first_name,date_of_birth,age,phone,gender,blood_type,adress,identity_card_number)values(?,?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,nameC );
            ps.setString(2,FirstName );
            ps.setString(3,DateB );
            ps.setString(4,age );
            ps.setString(5,phone );
            ps.setString(6,gender );
            ps.setString(7,bloodType);
            ps.setString(8,adress );
            ps.setString(9,identityNum );
            int rs=ps.executeUpdate();
            return rs>0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }  
    public void affichage(){
        String query ="select *from condidate ";
        PreparedStatement ps ;
        ResultSet rs;
        String candidateInf[] = {"Name", "FirstName", "DateBirth"," Age", "Phone"," Gender"," BloodType"," Adress", "NumCard"};  
        String[] afficher=new String[9];
        DefaultTableModel model =new DefaultTableModel(null, candidateInf);
        try {
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            model.setRowCount(0);
            //pour recuperer toutes leslignes
            while (rs.next()){
            afficher[0] = rs.getString("name");
            afficher[1] = rs.getString("first_name");
            afficher[2] = rs.getString("date_of_birth");
            afficher[3] = rs.getString("age");
            afficher[4] = rs.getString("phone");
            afficher[5] = rs.getString("gender");
            afficher[6] = rs.getString("blood_type");
            afficher[7] = rs.getString("address");
            afficher[8] = rs.getString("identity_card_number");
            model.addRow(afficher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
