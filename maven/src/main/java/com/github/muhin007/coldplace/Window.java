package com.github.muhin007.coldplace;

import javax.swing.*;

class Window extends JFrame {
    public static void main(String[] args) {

        Window window = new Window();
        window.setVisible(true);
    }

    private Window() {
        super();
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        this.add(getJLabel(), null);
        this.add(getJTextField(), null);
        this.add(getJButton(), null);
        this.setTitle("coldplace");
    }

    private javax.swing.JLabel getJLabel() {
        JLabel jLabel;
            jLabel = new JLabel();
            jLabel.setBounds(34, 49, 53, 18);
            jLabel.setText("City:");
        return jLabel;
    }

    private javax.swing.JTextField getJTextField() {
        JTextField jTextField;
            jTextField = new JTextField();
            jTextField.setBounds(96, 49, 160, 20);
        return jTextField;
    }

    private javax.swing.JButton getJButton() {
        JButton jButton;
            jButton = new JButton();
            jButton.setBounds(103, 110, 71, 27);
            jButton.setText("OK");
        return jButton;
    }

}
