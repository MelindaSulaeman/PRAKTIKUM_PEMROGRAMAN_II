package TUGAS_2.Latihan_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloTextArea extends JFrame {
     public HelloTextArea() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel labelInput = new JLabel("Input Nama : ");
        labelInput.setBounds(130,40,100,10);

        JTextField textField = new JTextField();
        textField.setBounds(130,60,100,30);

        JButton button = new JButton("Klik");
        button.setBounds(130,85,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130,130,150,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                txtOutput.append("Hello " + nama + "\n");
                textField.setText("");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(txtOutput);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextArea h = new HelloTextArea();
                h.setVisible(true);
            }
        });
    }
}
