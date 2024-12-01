package view.jenismember;

import dao.JenisMemberDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.JenisMember;
import view.jenismemberdetail.JenisMemberDetailFrame;

public class JenisMemberFrame extends JFrame {
    
    private List<JenisMember> jenisMemberList;
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;


    public JenisMemberFrame(JenisMemberDao jenisMemberDao){
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15,40,350,10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,100,100,40);

        javax.swing.JTable table = new JTable();    
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,150,350,200); 

        tableModel = new JenisMemberTableModel(jenisMemberList); 
        table.setModel(tableModel);

        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this,  jenisMemberDao);

        button.addActionListener(actionListener);


       table.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Double click untuk membuka detail
                        int row = table.getSelectedRow();
                        JenisMember selectedJenisMember = jenisMemberList.get(row);
                        JenisMemberDetailFrame detailFrame = new JenisMemberDetailFrame(selectedJenisMember, jenisMemberDao);
    
                        detailFrame.setVisible(true);
                    }
                }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400,500);
        this.setLayout(null);

    }

    public String getName(){
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember){
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }

}
