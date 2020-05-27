package com.github.kaazikin.jackbox;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;



public class EntryForm {
    private JTextField textField1;
    private JButton addNumberButton;
    private JButton sendTextButton;
    private JList numberList;
    protected JPanel mainPanel;
    private JButton deleteNumberButton;
    private Random rand;
    private ArrayList<String> numberContainer;

    public EntryForm() {
        rand = new Random(System.nanoTime());
        numberContainer = new ArrayList();
        DefaultListModel model = new DefaultListModel();
        numberList.setModel(model);

        addNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement(textField1.getText());
                numberContainer.add(textField1.getText());
                textField1.setText("");
            }
        });
        sendTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> outputNames = usernamePicker(numberContainer.size());
                for(int i = 0; i < outputNames.size(); i++){
                    String msg = "Your auto-generated username is " + outputNames.get(i) + ".";
                    sendMessage(numberContainer.get(i), msg);
                }
            }
        });
        deleteNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s = numberContainer.remove(numberList.getSelectedIndex());
                    model.removeElementAt(numberList.getSelectedIndex());
                } catch (Exception a){
                    System.out.println(a.toString())
;                }
            }
        });
    }

    private ArrayList<String> usernamePicker(int size){
        ArrayList<String> output = new ArrayList();
        for(int i = 0; i < size; i++){
            output.add(Main.usernames.get(rand.nextInt(Main.usernames.size()-1)));
        }
        return output;
    };

    private void sendMessage(String phoneNumber, String content){
        Message message = Message
                .creator(new PhoneNumber(phoneNumber), new PhoneNumber(Main.fromNumber), content)
                .create();
    }


}
