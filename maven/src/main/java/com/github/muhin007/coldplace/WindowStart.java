package com.github.muhin007.coldplace;

import javax.swing.*;

class WindowStart extends JFrame {
    public static void main(String[] args) {

        WindowStart window = new WindowStart();
        window.setVisible(true);
    }

    private WindowStart() {
        super();
        this.setSize(400, 200);
        this.getContentPane().setLayout(null);
        this.add(getJLabel(), null);
        this.add(getJTextField(), null);
        this.add(getJButton(), null);
        this.setTitle("coldplace");
    }

    private javax.swing.JLabel getJLabel() {
        JLabel jLabel;
            jLabel = new JLabel();
            jLabel.setBounds(30, 49, 200, 20);
            jLabel.setText("Введите название города:");
        return jLabel;
    }

    private javax.swing.JTextField getJTextField() {
        JTextField jTextField;
            jTextField = new JTextField();
            jTextField.setBounds(200, 49, 160, 20);
        return jTextField;
    }

    private javax.swing.JButton getJButton() {
        JButton jButton;
            jButton = new JButton();
            jButton.setBounds(150, 110, 71, 27);
            jButton.setText("OK");
        return jButton;
    }

}
