package view.member;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.JenisMember; // Import class baru
import model.Member;
import view.memberdetail.MemberDetailFrame;

public class MemberFrame extends JFrame {
    
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox comboJenis;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;
    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;

        this.memberList = this.memberDao.findAll();
        this.jenisMemberList = this.jenisMemberDao.findAll();

        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15,40,350,10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);

        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15,100,350,10);

        comboJenis = new JComboBox();
        comboJenis.setBounds(15,120,150,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,160,100,40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,210,350,200);

        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);

        button.addActionListener(actionListener);

        table.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Double click untuk membuka detail
                        int row = table.getSelectedRow();
                        Member selectedMember = memberList.get(row);
                        MemberDetailFrame detailFrame = new MemberDetailFrame(selectedMember, memberDao, jenisMemberDao);
                        detailFrame.populateComboJenis();
                        detailFrame.setVisible(true);
                    }
                }
         });
        
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        this.add(labelJenis);
        this.add(comboJenis);
        
        this.setSize(400,500);
        this.setLayout(null);
    }

    public void populateComboJenis(){
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for(JenisMember jenisMember: this.jenisMemberList){
            comboJenis.addItem(jenisMember.getNama());
        }
    }

    public String getName(){
        return textFieldNama.getText();
    }

    public JenisMember getJenisMember(){
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    public void addMember(Member member){
        tableModel.add(member);
        textFieldNama.setText("");
    }

    public void showAlert(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
