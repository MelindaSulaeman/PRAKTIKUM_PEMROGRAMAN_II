package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
  private JTextField txtName = new JTextField(20);
  private JTextField txtEmail = new JTextField(20);
  private JButton btnAdd = new JButton("Add User");
  private JButton btnRefresh = new JButton("Refresh");
  private JList<String> userList = new JList<>();
  private DefaultListModel<String> listModel = new DefaultListModel<>();

  public UserView() {
    setTitle("User Management");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(5, 1));
    panel.add(new JLabel("Name:"));
    panel.add(txtName);
    panel.add(new JLabel("Email:"));
    panel.add(txtEmail);

    JPanel buttoPanel = new JPanel();
    buttoPanel.add(btnAdd);
    buttoPanel.add(btnRefresh);
    panel.add(buttoPanel);

    userList.setModel(listModel);
    add(panel, BorderLayout.NORTH);
    add(new JScrollPane(userList), BorderLayout.CENTER);
  }

  public String getNameInput() {
    return txtName.getText();
  }

  public String getEmailInput() {
    return txtEmail.getText();
  }

  public void setUserList(String[] users) {
    listModel.clear();
    for (String user : users) {
      listModel.addElement(user);
    }
  }

  public void addAddUserListener(ActionListener listener) {
    btnAdd.addActionListener(listener);
  }

  public void addRefreshListener(ActionListener listener) {
    btnRefresh.addActionListener(listener);
  }
}