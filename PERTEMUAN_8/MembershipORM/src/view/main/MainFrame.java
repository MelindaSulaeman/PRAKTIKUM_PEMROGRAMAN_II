package view.main;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.jenismember.JenisMemberFrame;
import view.member.MemberFrame;

public class MainFrame extends JFrame {
    private JenisMemberFrame jenisMemberFrame ;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;

    public MainFrame(JenisMemberDao jenisMemberDao, MemberDao memberDao){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(400,500);

        this.jenisMemberDao = jenisMemberDao;
        this.memberDao = memberDao;

        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisMember = new JButton("Jenis Member: ");
        this.buttonMember = new JButton("Member");

        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);

        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember(){
        return buttonJenisMember;
    }

    public JButton getButtonMember(){
        return buttonMember;
    }

    public void showJenisMemberFrame(){
        if(jenisMemberFrame == null){
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }


    public void showMemberFrame(){

        if(memberFrame == null){
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        memberFrame.populateComboJenis();
        memberFrame.setVisible(true);
    }
}
