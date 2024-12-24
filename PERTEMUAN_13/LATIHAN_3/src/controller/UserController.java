package controller;

import model.*;
import view.UserView;
import view.UserPdf;

import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getUserList().setEnabled(false);
            SwingWorker<Void, String[]> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    List<User> users = mapper.getAllUsers();
                    String[] userArray = users.stream()
                            .map(u -> u.getName() + " (" + u.getEmail() + ")")
                            .toArray(String[]::new);
                    publish(userArray);
                    return null;
                }

                @Override
                protected void process(List<String[]> chunks) {
                    view.setUserList(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    view.getUserList().setEnabled(true);
                    JOptionPane.showMessageDialog(view, "Refresh completed!");
                }
            };
            worker.execute();
        }
    }

    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    List<User> users = mapper.getAllUsers();
                    pdf.exportPdf(users);
                    return null;
                }

                @Override
                protected void done() {
                    JOptionPane.showMessageDialog(view, "Export to PDF completed!");
                }
            };
            worker.execute();
        }
    }
}