package main;

import dao.JenisMemberDao;
import dao.MemberDao;   
import java.io.File;
import java.io.IOException;
import java.io.InputStream; 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import view.main.MainFrame;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);

        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }
}
