package com.github.muhin007.coldplace;

import javax.swing.*;
import java.awt.event.*;

public class Panel1 extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton button1;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Panel1() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        Panel1 dialog = new Panel1();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
