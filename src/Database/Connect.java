/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ThinkPad
 */
public class Connect {

    public Connection conn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // hna ychecki esq driver hadak kayan wla nn
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
        }
        System.out.println("Oracle JDBC Driver Registered!"); // hna ma3ntha l9a driver ta3 oracle bach ykonikti b database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ines");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }
}
