/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_4;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class WindowListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowListener Example");
        
        JLabel label = new JLabel("Lakukan operasi pada jendela.");
        label.setBounds(50, 50, 300, 30);
        

        frame.addWindowListener(new WindowListener(){
            public void windowOpened(WindowEvent e){
                label.setText("Window Opened.");
            }
            
            public void windowClosing(WindowEvent e){
                label.setText("Window Closing.");
            }
            
            public void windowClosed(WindowEvent e){
                label.setText("Window Closed.");
            }
            
            public void windowIconified(WindowEvent e){
                label.setText("Window Minimized.");
            }
            
            public void windowDeiconfied(WindowEvent e){
                label.setText("Window Restored.");
            }
            
            public void windowActivated(WindowEvent e){
                label.setText("Window Activated.");
            }
            
            public void windowDeactivated(WindowEvent e){
                label.setText("Window Deactivated.");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        frame.add(label);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
