/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class ComboBoxModalExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBoxModel Example");
        
        // Membuat model dengan opsi
        DefaultComboBoxModel<String> comboBoxModel = new
        DefaultComboBoxModel<>();
        comboBoxModel.addElement("Item 1");
        comboBoxModel.addElement("Item 2");
        comboBoxModel.addElement("Item 3");
        comboBoxModel.addElement("Item 4");
        
        // Membuat JComboBox dengan model
        JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);
       
        // Tambahkan listener untuk JComboBox
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan item yang dipilih
                String selectedItem = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selectedItem);
            }
        });
        
        // Mengatur layout dan menambahkan JComboBox ke JFrame
        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);
        
        // Konfigurasi JFrame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
