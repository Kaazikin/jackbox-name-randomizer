package com.github.kaazikin.jackbox;

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
    private Random rand;
    private ArrayList numberContainer;

    public EntryForm() {
        rand = new Random(System.nanoTime());
        numberContainer = new ArrayList<String>();
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


}
