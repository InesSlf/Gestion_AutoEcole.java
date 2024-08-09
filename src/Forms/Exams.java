/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Database.CRUD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThinkPad
 */
public class Exams extends javax.swing.JFrame {

    /**
     * Creates new form Exams
     */
    public Exams() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCheck = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtIDc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtFname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jcCode = new javax.swing.JCheckBox();
        jcParking = new javax.swing.JCheckBox();
        jcDriving = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableExams = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/timetable.png"))); // NOI18N
        jLabel1.setText("Exams ");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identity Card Number");

        jtIDc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtIDcKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Condidate Full Name ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Exam Type ");

        buttonGroupCheck.add(jcCode);
        jcCode.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jcCode.setForeground(new java.awt.Color(255, 255, 255));
        jcCode.setText("Code");

        buttonGroupCheck.add(jcParking);
        jcParking.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jcParking.setForeground(new java.awt.Color(255, 255, 255));
        jcParking.setText("Parking ");

        buttonGroupCheck.add(jcDriving);
        jcDriving.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jcDriving.setForeground(new java.awt.Color(255, 255, 255));
        jcDriving.setText("Driving");
        jcDriving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcDrivingActionPerformed(evt);
            }
        });

        TableExams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID card", "Full Name ", "Date ", "Type "
            }
        ));
        TableExams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableExamsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableExams);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 153));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 153, 153));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eraser.png"))); // NOI18N
        btnClear.setText("Clear ");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(0, 153, 153));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        btnDel.setText("Delete ");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModify.setForeground(new java.awt.Color(0, 153, 153));
        btnModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit (1).png"))); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtFname)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcCode, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcParking, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcDriving, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtIDc)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDel)
                    .addComponent(btnModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtIDc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcCode)
                            .addComponent(jcParking)
                            .addComponent(jcDriving))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear)
                            .addComponent(btnAdd)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.toBack();
        home_screen hc = new home_screen();
        hc.setVisible(true);
        hc.toFront();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    CRUD crud =new CRUD();
            
    private void jcDrivingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcDrivingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcDrivingActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       String IDc=jtIDc.getText();
       //String Fname =jtFname.getText();
       String Date = sdf.format(jtDate.getDate());
       String Type = "";
        if (jcCode.isSelected()) {
            Type = "Code";
        } else if (jcDriving.isSelected()) {
            Type = "Driving";
        } else if (jcParking.isSelected()) {
            Type = "Parking";
        }
        String candidateFullName = crud.getCondidateNameById(IDc);
        if(IDc.isEmpty()|| Date.isEmpty()||!(jcCode.isSelected() || jcDriving.isSelected() || jcParking.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel model =(DefaultTableModel) TableExams.getModel();
            model.addRow(new Object[]{IDc, candidateFullName,Date,Type});
            jtIDc.setText("");
            jtFname.setText("");
            jtDate.setCalendar(null);
            buttonGroupCheck.clearSelection();
        }
        if(crud.addExam(IDc, candidateFullName, Date, Type)){
            JOptionPane.showMessageDialog(this, "The exam has been added successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        jtIDc.setText("");
        jtFname.setText("");
        jtDate.setCalendar(null);
        buttonGroupCheck.clearSelection();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jtIDcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtIDcKeyReleased
        String idc = jtIDc.getText().trim();
        jtFname.setText(crud.getCondidateNameById(idc));
    }//GEN-LAST:event_jtIDcKeyReleased

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        DefaultTableModel model = (DefaultTableModel) TableExams.getModel();
        try {
        int selectedRow = TableExams.getSelectedRow();
        model.removeRow(selectedRow);
        crud.deleteExam(jtIDc.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No row is selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        jtIDc.setText("");
        jtFname.setText("");
        jtDate.setCalendar(null);
        buttonGroupCheck.clearSelection();
    }//GEN-LAST:event_btnDelActionPerformed

    private void TableExamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableExamsMouseClicked
        int selectedRow = TableExams.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableExams.getModel();
        jtIDc.setText(model.getValueAt(selectedRow, 0).toString());
        jtFname.setText(model.getValueAt(selectedRow, 1).toString());
         Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(model.getValueAt(selectedRow, 2).toString());
            jtDate.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Type = model.getValueAt(selectedRow, 3).toString();
        switch (Type) {
            case "Code":
                jcCode.setSelected(true);
                break;
            case "Driving":
                jcDriving.setSelected(true);
                break;
            case "Parking":
                jcParking.setSelected(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_TableExamsMouseClicked

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        int i = TableExams.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableExams.getModel();
        if (i >= 0) {
            String IDc = jtIDc.getText();
            String fName = jtFname.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String Date = sdf.format(jtDate.getDate());
            String candidateFullName = crud.getCondidateNameById(IDc);
            String Type;
            if (jcCode.isSelected()) {
                Type = "Code";
            } else if (jcDriving.isSelected()) {
                Type = "Driving";
            } else if (jcParking.isSelected()) {
                Type = "Parking";
            } else {
                Type = "";
            }
            crud.updateExam(IDc, fName, Date, Type);
            model.setValueAt(IDc, i, 0);
            model.setValueAt(fName, i, 1);
            model.setValueAt(Date, i, 2);
            model.setValueAt(Type, i, 3);
            jtFname.setText(crud.getCondidateNameById(IDc));
        } else {
            JOptionPane.showMessageDialog(this, "No row selected ", "Try again !", JOptionPane.ERROR_MESSAGE);
        }
        jtIDc.setText("");
        jtFname.setText("");
        jtDate.setCalendar(null);
        buttonGroupCheck.clearSelection();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        crud.displayaDataExams(TableExams);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableExams;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnModify;
    private javax.swing.ButtonGroup buttonGroupCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcCode;
    private javax.swing.JCheckBox jcDriving;
    private javax.swing.JCheckBox jcParking;
    private com.toedter.calendar.JDateChooser jtDate;
    private javax.swing.JTextField jtFname;
    private javax.swing.JTextField jtIDc;
    // End of variables declaration//GEN-END:variables
}
