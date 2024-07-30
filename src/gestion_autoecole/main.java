/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_autoecole;

import Database.Connect;
import Forms.*;
import java.sql.Connection;

/**
 *
 * @author msii
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here          
        /*
        System.out.println("Hey Ines!, Let's get started");
        System.out.println("Hey Faical ");
        System.out.println("mna w jay mat9olilich man3rfch ndir push and pull psq marahch n3awnk cbn! ^^");
         */
        signIn login = new signIn();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        Connect conn = new Connect();
        Connection c = conn.connect();
    }
}
