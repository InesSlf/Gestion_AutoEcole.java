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
            ps.setString(2, getEncryptedPassword(username));
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getEncryptedPassword(String username) {
        String query = "select password from register where user_name=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                String encryptedPassword = rs.getString("password");
                return decrypt(encryptedPassword, 5);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERROR !";
    }

    public static String decrypt(String password, int shift) {
        StringBuilder decryptedPass = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((c - 'a' - shift + 26) % 26 + 'a');
            } else if (Character.isDigit(c)) {
                c = (char) ((c - '0' - shift + 10) % 10 + '0');
            }
            decryptedPass.append(c);
        }
        return decryptedPass.toString();
    }
    // ==================== Condidate Methods ==================== //

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
            if (rs.next()) {
                return rs.getString("name").concat(" ").concat(rs.getString("first_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public boolean addSession(String sessionID, String identityNum, String condidateFullName, String DateS, int hour, String Type) {
        //condidateFullName =getCondidateNameById(identityNum);
        String query = "insert into sessionP (session_ID,condidate_full_name,identity_card_number,session_date,hour,session_type) values(?,?,?,to_date(?, 'DD-MM-YYYY'),?,?) ";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, sessionID);
            ps.setString(2, getCondidateNameById(identityNum));
            ps.setString(3, identityNum);
            ps.setString(4, DateS);
            ps.setInt(5, hour);
            ps.setString(6, Type);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void displayDataSessionTable(JTable tabName) {
        String query = "select sessionP.*, to_char(session_date,'DD-MM-YYYY') as formatted_date from sessionP";
        String[] session = new String[6];
        DefaultTableModel model = (DefaultTableModel) tabName.getModel();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                session[0] = rs.getString("identity_card_number");
                session[1] = rs.getString("condidate_full_name");
                session[2] = rs.getString("session_ID");
                session[3] = rs.getString("formatted_date");
                session[4] = rs.getString("hour");
                session[5] = rs.getString("session_type");
                model.addRow(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSession(String fullName) {
        String query = "delete from sessionP where condidate_full_name =? ";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSession(String sessionID, String identityNum, String condidateFullName, String DateS, int hour, String Type) {
        String query = "update sessionP set session_ID=?,condidate_full_name=?,session_date=to_date(?,'DD-MM-YYYY'),hour=?,session_type=? where identity_card_number=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, sessionID);
            ps.setString(2, condidateFullName);
            ps.setString(3, DateS);
            //ps.setString(4, DateS);
            ps.setInt(4, hour);
            ps.setString(5, Type);
            ps.setString(6, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ==================== Payment Methods ==================== //
    public boolean addPayment(String payment_ID, String identityNum, String amount, String instAmount, String remBalance, int nbr, String dateP) {
        String query = "insert into payment (payment_ID, identity_card_number, amount, installment_amount, remaining_balance, number_installments, payment_date) values(?,?,?,?,?,?,to_date(?, 'DD-MM-YYYY'))";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, payment_ID);
            ps.setString(2, identityNum);
            ps.setString(3, amount);
            ps.setString(4, instAmount);
            ps.setString(5, remBalance);
            ps.setInt(6, nbr);
            ps.setString(7, dateP);

            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void displayDataPayment(JTable tab) {
        String query = "select payment.*, to_char(payment_date,'DD-MM-YYYY') as formatted_date from payment";
        String[] payment = new String[7];
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                payment[0] = rs.getString("payment_ID");
                payment[1] = rs.getString("identity_card_number");
                payment[2] = rs.getString("amount");
                payment[3] = rs.getString("installment_amount");
                payment[4] = rs.getString("remaining_balance");
                payment[5] = rs.getString("number_installments");
                payment[6] = rs.getString("payment_date");
                model.addRow(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePay(String identityNum) {
        String query = "delete from payment where identity_card_number =?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePay(String paymentID, String identityNum, String amount, String instAmount, String remBalance, int nbr, String Date) {
        //String query = "update payment set payment_ID=?,amount =?,installment_amount=?,remainig_balance =?,number_installments=?,payment_date=to_date(?,'DD-MM-YYYY') where identity_card_number =?";
        String query = "update payment set payment_ID=?,amount =?,installment_amount=?,remaining_balance =?,number_installments=?,payment_date=to_date(?,'DD-MM-YYYY') where identity_card_number =?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, paymentID);
            ps.setString(2, amount);
            ps.setString(3, instAmount);
            ps.setString(4, remBalance);
            ps.setInt(5, nbr);
            ps.setString(6, Date);
            ps.setString(7, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ==================== Exams Methods ==================== //
    public boolean addExam(String IDc, String fName, String date, String type) {
        String query = "insert into exams (identity_card_number,full_name,exam_date,exam_type)values(?,?,to_date(?, 'DD-MM-YYYY'),?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, IDc);
            ps.setString(2, fName);
            ps.setString(3, date);
            ps.setString(4, type);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void displayaDataExams(JTable tab) {
        String query = "select exams.*, to_char(exam_date,'DD-MM-YYYY') as formatted_date from exams";
        String[] exams = new String[4];
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                exams[0] = rs.getString("identity_card_number");
                exams[1] = rs.getString("full_name");
                exams[2] = rs.getString("formatted_date");
                exams[3] = rs.getString("exam_type");
                model.addRow(exams);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteExam(String identityNum) {
        String query = "delete from exams where identity_card_number =?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, identityNum);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateExam(String IDc, String fName, String date, String type) {
        String query = "update exams set full_name =?,exam_date=to_date(?,'DD-MM-YYYY'),exam_type=? where identity_card_number=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, fName);
            ps.setString(2, date);
            ps.setString(3, type);
            ps.setString(4, IDc);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ==================== Rapport Methods ==================== //
    public String getHours(String condidateID, String sessionType) {
        String query = "select sum(hour) as total_hours from sessionP where session_type = ? and identity_card_number = ?";
        String totalHours = "0";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, sessionType);
            ps.setString(2, condidateID);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalHours = rs.getString("total_hours");
                totalHours = totalHours != null ? totalHours : "0";
                return totalHours;
            } else {
                return totalHours;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR!";
        }
    }

    public String getExamDate(String condidateID) {
        String query = "select to_char(exam_date,'DD-MM-YYYY') as formatted_date from exams where identity_card_number = ? and exam_type = 'Driving'";
        String date = "0";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, condidateID);
            rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getString("formatted_date");
                date = date != null ? date : "0";
                return date;
            } else {
                return date;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR!";
        }
    }
}
