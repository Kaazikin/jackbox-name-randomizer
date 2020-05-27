package com.github.kaazikin.jackbox;

import com.twilio.Twilio;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> usernames;
    public static Properties prop;
    public static String accountSID;
    public static String authToken;
    public static String fromNumber;
    public static void main(String[] args){
        usernames = new ArrayList();
        prop = new Properties();
        readFile();

        accountSID = prop.getProperty("account.sid");
        authToken = prop.getProperty("account.token");
        fromNumber = prop.getProperty("account.phonenumber");

        Twilio.init(accountSID, authToken);

        JFrame frame = new JFrame("EntryForm");
        frame.setContentPane(new EntryForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static void readFile(){
        String fileName = "resources/usernames.txt";
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                usernames.add(data);
            }
            FileReader propReader = new FileReader("resources/application.properties");
            prop.load(propReader);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
