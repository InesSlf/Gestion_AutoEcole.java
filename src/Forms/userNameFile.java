/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author msii
 */
public class userNameFile {

    public void writeUsernameToFile(String userName) {
        try {
            FileWriter writer = new FileWriter("username.txt", false);
            writer.write(userName);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readUsernameFromFile() {
        String userName = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("username.txt"));
            userName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }

        return userName;
    }

}
