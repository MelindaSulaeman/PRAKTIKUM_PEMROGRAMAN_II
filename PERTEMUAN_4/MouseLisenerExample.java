/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class MouseLisenerExample {
    public static void main(String[] args) {
        //Membuat frame
        JFrame frame = new JFrame("MouseListener Example");
        
        //Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
        label.setBounds(50, 50, 300, 30);
        
        //Menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener() {
            //Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at : (" + e.getX() + "," + e.getY() + ")");
            }
            
            //Dijalankan ketika mouse ditekan (tanpa dilepaskan)
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at : (" + e.getX() + "," + e.getY() + ")");
            }
            
            // Dijalankan ketika mouse dilepas setelah ditekan
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at : (" + e.getX() + "," + e.getY() + ")");
            }
            
            //Dijalankan ketika mouse masuk ke area komponen
            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered the area.");
            }
            
            //dijalankan letika mouse keluar dari area komponen
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited the area.");
            }
        });
        
        //Menambahkan label ke frame
        frame.add(label);
        
        //Setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
