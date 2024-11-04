/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERTEMUAN_7.membership.src.view.main;

import java.awt.event.*;

public class MainButtonActionListener implements ActionListener{
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == mainFrame.getButtonJenisMember()){
            mainFrame.showJenisMemberFrame();
        } else {
            mainFrame.showMemberFrame();
        }
    }
}