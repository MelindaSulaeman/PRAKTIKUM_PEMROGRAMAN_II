package view.memberdetail;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.JenisMember;
import model.Member;


public class MemberDetailFrame extends JFrame {

    private JTextField textFieldId;
    private JTextField textFieldNama;
    private Member member;
    private MemberDao memberDao;
    private JComboBox comboJenis;
    private List<JenisMember> jenisMemberList;
    private JenisMemberDao jenisMemberDao;

    public MemberDetailFrame(Member member, MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.member = member;
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(15, 40, 350, 10);
        textFieldId = new JTextField(member.getId());
        textFieldId.setBounds(15, 60, 350, 30);
        textFieldId.setEditable(false);  // ID tidak bisa diedit

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 100, 350, 10);
        textFieldNama = new JTextField(member.getNama());
        textFieldNama.setBounds(15, 120, 350, 30);

        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15,160,350,10);

        comboJenis = new JComboBox();
        comboJenis.setBounds(15,180,350,30);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(15, 240, 100, 40);
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMember();
            }
        });

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(125, 240, 100, 40);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMember();
            }
        });

        this.add(labelId);
        this.add(textFieldId);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(buttonUpdate);
        this.add(buttonDelete);
        this.add(labelJenis);
        this.add(comboJenis);

        this.setSize(400, 500);
        this.setLayout(null);
    }


    public void populateComboJenis(){
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for(JenisMember jenisMember: this.jenisMemberList){
            comboJenis.addItem(jenisMember.getNama());
        }
    }


    private void updateMember() {
        JenisMember jenisMember = this.getJenisMember();
        member.setNama(textFieldNama.getText());
        member.setJenisMember(jenisMember);
        member.setJenisMemberId(jenisMember.getId());
        memberDao.update(member);
        this.dispose(); // Tutup window setelah update
        // Refresh tabel di MemberFrame (lihat langkah 3)
    }

    private void deleteMember() {
        memberDao.delete(member.getId()); //Asumsi ID adalah integer
        this.dispose(); // Tutup window setelah delete
        // Refresh tabel di MemberFrame (lihat langkah 3)
    }

    public JenisMember getJenisMember(){
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    
}