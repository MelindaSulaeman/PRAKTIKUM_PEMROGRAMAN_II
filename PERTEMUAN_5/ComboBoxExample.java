/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");
        String[] options = { "Option 1", "Option 2", "Option 3", "Option 4" };
        
        //Membuat JComboBox dengan opsi
        JComboBox<String> comboBox = new JComboBox<>(options);
        
        //Tambahkan pendengar aksi
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //Mengambil item yang dipilih
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selected);
            }
        });
        
        //Atur layout dan tambahkan ke frame
        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);
        
        //Komfirgurasi frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
