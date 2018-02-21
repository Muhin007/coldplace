package com.github.muhin007.coldplace;

import javax.swing.*;

class WindowCity extends JFrame {

    public static void main(String[] args) {

        WindowCity window = new WindowCity();
        window.setVisible(true);
    }

    private WindowCity() {
        super();
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        this.add(getJLabel(), null);
        this.setTitle("coldplace");
    }

    private javax.swing.JLabel getJLabel() {
        JLabel jLabel;
        jLabel = new JLabel();
        jLabel.setBounds(34, 49, 200, 18);
        jLabel.setText("здесь выводим температуру");
        return jLabel;
    }

}

