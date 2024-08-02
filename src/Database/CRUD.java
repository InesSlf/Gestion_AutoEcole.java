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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author msii
 */
public class CRUD {

    Connection conn = new Connect().connect();
    PreparedStatement ps;//envoie la requete
    ResultSet rs;//recupere les infos 

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

    public boolean addCondidate(String nameC, String FirstName, String DateB, String age, String phone, String gender, String bloodType, String adress, String identityNum) {
        String query = "insert into condidate (name,first_name,date_of_birth,age,phone,gender,blood_type,adress,identity_card_number)values(?,?,to_date(?, 'DD-MM-YYYY'),?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nameC);
            ps.setString(2, FirstName);
            ps.setString(3, DateB);
            ps.setString(4, age);
            ps.setString(5, phone);
            ps.setString(6, gender);
            ps.setString(7, bloodType);
            ps.setString(8, adress);
            ps.setString(9, identityNum);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void display_data(JTable tableName) {
        String query = "select condidate.*, to_char(date_of_birth,'DD-MM-YYYY') as formatted_date from condidate";
        String[] afficher = new String[9];
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            model.setRowCount(0);
            //pour recuperer toutes leslignes
            while (rs.next()) {
                afficher[0] = rs.getString("name");
                afficher[1] = rs.getString("first_name");
                afficher[2] = rs.getString("formatted_date");
                afficher[3] = rs.getString("age");
                afficher[4] = rs.getString("phone");
                afficher[5] = rs.getString("gender");
                afficher[6] = rs.getString("blood_type");
                afficher[7] = rs.getString("adress");
                afficher[8] = rs.getString("identity_card_number");
                model.addRow(afficher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCondidate(String name, String firstName, String DateB, String age, String phone, String gender, String bloodType, String address, String identityNum) {
        String query = "update condidate set name=?,first_name=?,date_of_birth=to_date(?,'DD-MM-YYYY'),age=?,phone=?,gender=?,blood_type=?,adress=? where identity_card_number=?  ";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, firstName);
            ps.setString(3, DateB);
            ps.setString(4, age);
            ps.setString(5, phone);
            ps.setString(6, gender);
            ps.setString(7, bloodType);
            ps.setString(8, address);
            ps.setString(9, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteCondidate(String identityNum) {
        String query = "delete from condidate where identity_card_number =? ";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, identityNum);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ==================== Session Planner Methods ==================== //
    public String getCondidateNameById(String cardNumber) {
        String query = "select name, first_name from condidate where identity_card_number = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, cardNumber);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("name").concat(" ").concat(rs.getString("first_name"));
            }                        
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public boolean addSession (String sessionID,String identityNum ,String condidateFullName,String DateS, int hour,String Type){
        //condidateFullName =getCondidateNameById(identityNum);
        String query ="insert into sessionP (session_ID,condidate_full_name,identity_card_number,session_date,hour,session_type) values(?,?,?,?,?,?) ";
        PreparedStatement ps;
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1, sessionID);
            ps.setString(2,identityNum);
            ps.setString(3,getCondidateNameById(identityNum) );
            ps.setString(4, DateS);
            ps.setInt(5, hour);
            ps.setString(6, Type);
           int rs= ps.executeUpdate();
           return rs > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }
   /* public String getIDsession (String identityNum){
          String query ="select ID_C from condidate where identity_card_num =?";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1, identityNum);
            ps.executeQuery();
            if (rs.next()) {
            return rs.getString("session_ID"); 
        }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          return "";
    }*/
    public void displayDataSessionTable(JTable tabName){
          String query = "select sessionP.*, to_char(session_date,'DD-MM-YYYY') as formatted_date from sessionP";
          String[] session = new String[6];
          DefaultTableModel model =(DefaultTableModel) tabName.getModel();
        try {
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                session[0] = rs.getString("session_ID");
                session[1] = rs.getString("condidate_full_name");
                session[2] = rs.getString("identity_card_number");
                session[3] = rs.getString("formatted_date");
                session[4] = rs.getString("hour");
                session[5] = rs.getString("session_type");
                model.addRow(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteSession (String identityNum){
            String query ="delete from sessionP where identity_card_number =? ";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public void updateSession (String sessionID,String identityNum ,String condidateFullName,String DateS, int hour,String Type){
           String query ="update sessionP set session_ID=?,condidate_full_name=?,session_date=to_date(?,'DD-MM-YYYY'),hour=?,session_type=? where identity_card_number=?";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1, sessionID);
            ps.setString(2, condidateFullName);
            ps.setString(3, identityNum);
            ps.setString(4, DateS);
            ps.setInt(5, hour);
            ps.setString(6,Type);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
