package PERTEMUAN_7.membership.src.view.member;

import java.awt.event.*;
import java.util.UUID;
import PERTEMUAN_7.membership.src.model.*;
import PERTEMUAN_7.membership.src.dao.MemberDao;

public class MemberButtonSimpanActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;
    
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the name from the frame
        String nama = this.memberFrame.getNama();
        
        // Validate if name is not empty
        if (nama.isEmpty()) {
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        } else {
            // Get selected JenisMember from the frame
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            
            // Create new Member instance
            Member member = new Member();
            // Generate a unique ID using UUID
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);
            
            // Update both the frame and database
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}