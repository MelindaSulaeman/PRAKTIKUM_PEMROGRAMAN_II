/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_5;

/**
 *
 * @author ACER
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("JTable Example");
        
        // Membuat tabel dengan data awal dan header kolom
        String[] columnNames = { "ID", "Name", "Age" };
        Object[][] data = {
            { 1, "John", 25 },
            { 2, "Anna", 30 },
            { 3, "Mike", 35 },
        };
        
        // Membuat model tabel
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Membuat JTable dengan model
        JTable table = new JTable(model);
        
        // Membuat JScrollPane untuk menampung JTable
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Menambahkan JScrollPane ke frame
        frame.add(scrollPane);
        
        // Konfigurasi frame
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}

