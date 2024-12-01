package view.jenismemberdetail;

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


public class JenisMemberDetailFrame extends JFrame {

    private JTextField textFieldId;
    private JTextField textFieldNama;
    private JenisMember jenisMember;
    private JenisMemberDao jenisMemberDao;
    private JComboBox comboJenis;
    private List<JenisMember> jenisMemberList;

    public JenisMemberDetailFrame(JenisMember jenisMember,JenisMemberDao jenisMemberDao) {
        this.jenisMember = jenisMember;
        this.jenisMemberDao = jenisMemberDao;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(15, 40, 350, 10);
        textFieldId = new JTextField(jenisMember.getId());
        textFieldId.setBounds(15, 60, 350, 30);
        textFieldId.setEditable(false);  // ID tidak bisa diedit

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 100, 350, 10);
        textFieldNama = new JTextField(jenisMember.getNama());
        textFieldNama.setBounds(15, 120, 350, 30);

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

        this.setSize(400, 500);
        this.setLayout(null);
    }



    private void updateMember() {
        jenisMember.setNama(textFieldNama.getText());
        jenisMemberDao.update(jenisMember);
        this.dispose(); // Tutup window setelah update
        // Refresh tabel di MemberFrame (lihat langkah 3)
    }

    private void deleteMember() {
        jenisMemberDao.delete(jenisMember.getId()); //Asumsi ID adalah integer
        this.dispose(); // Tutup window setelah delete
        // Refresh tabel di MemberFrame (lihat langkah 3)
    }
    
}