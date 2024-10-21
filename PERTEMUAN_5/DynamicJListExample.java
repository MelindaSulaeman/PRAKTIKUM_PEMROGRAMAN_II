/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ACER
 */
public class DynamicJListExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic JList Example");
        
        // Membuat DefaultListModel
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Dynamic Item 1");
        listModel.addElement("Dynamic Item 2");
        listModel.addElement("Dynamic Item 3");
        
        // Membuat JList dengan model
        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // JScrollPane untuk JList
        JScrollPane scrollPane = new JScrollPane(list);
        
        // Tombol untuk menambahkan item baru
        JButton addButton = new JButton("Add Item");
        addButton.setBounds(50, 170, 100, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             listModel.addElement("New Item");
            }
        });
        
        // Tombol untuk menghapus item yang dipilih
        JButton removeButton = new JButton("Remove Item");
        removeButton.setBounds(160, 170, 120, 30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                    }
            }
        });
        
        // Mengatur layout dan menambahkan komponen ke frame
        frame.setLayout(null);
        scrollPane.setBounds(50, 50, 150, 100);
        frame.add(scrollPane);
        frame.add(addButton);
        frame.add(removeButton);
       
        // Konfigurasi frame
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

}
