package PERTEMUAN_6;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMataKuliah extends JFrame {
    private JTextField nameField, npmField;
    private JTextArea commentsArea; 
    private JComboBox<String> courseComboBox, statusComboBox;
    private JSpinner classSpinner;
    private JSlider semesterSlider;
    private JRadioButton maleRadioButton, femaleRadioButton; 
    private JTable enrollmentTable;
    private DefaultTableModel tableModel;
    private DefaultListModel<String> listModel;
    private JList<String> studentList;
    private JCheckBox receiveNotifCheckBox; 

    public FormMataKuliah() {
        setTitle("Form Pendaftaran Mata Kuliah");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        // Menu setup
        setupMenuBar();

        // Input form setup
        setupInputForm();

        // Table setup
        setupEnrollmentTable();

        // Student List setup
        setupStudentList();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
    

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void setupInputForm() {
        JPanel inputPanel = new JPanel(new GridBagLayout()); 
        inputPanel.setBorder(BorderFactory.createTitledBorder("Form Pendaftaran Mata Kuliah"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Student Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(15);
        inputPanel.add(nameField, gbc);

        // NPM
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("NPM:"), gbc);

        gbc.gridx = 1;
        npmField = new JTextField(15);
        inputPanel.add(npmField, gbc);

        // Course Selection
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Mata Kuliah:"), gbc);

        gbc.gridx = 1;
        courseComboBox = new JComboBox<>(new String[]{"Sistem Informasi", "Pemograman", "Perancangan", "Multimedia"});
        inputPanel.add(courseComboBox, gbc);

        // Class Selection
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Kelas:"), gbc);

        gbc.gridx = 1;
        classSpinner = new JSpinner(new SpinnerListModel(new String[]{"A", "B", "C", "D"}));
        inputPanel.add(classSpinner, gbc);

        // Semester
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Semester:"), gbc);

        gbc.gridx = 1;
        semesterSlider = new JSlider(1, 8, 1);
        semesterSlider.setMajorTickSpacing(1);
        semesterSlider.setPaintTicks(true);
        semesterSlider.setPaintLabels(true);
        inputPanel.add(semesterSlider, gbc);

        // Student Status
        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        statusComboBox = new JComboBox<>(new String[]{"Reguler", "Karyawan"});
        inputPanel.add(statusComboBox, gbc);

        // Gender Options using JRadioButton
        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc);

        gbc.gridx = 1;
        maleRadioButton = new JRadioButton("Laki-laki");
        femaleRadioButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        inputPanel.add(genderPanel, gbc);

        // Comments Area
        gbc.gridx = 0;
        gbc.gridy = 7;
        inputPanel.add(new JLabel("Comments:"), gbc);

        gbc.gridx = 1;
        commentsArea = new JTextArea(3, 15); // JTextArea untuk komentar
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        JScrollPane commentsScrollPane = new JScrollPane(commentsArea);
        inputPanel.add(commentsScrollPane, gbc);

        // Notification Checkbox
        gbc.gridx = 0;
        gbc.gridy = 8;
        inputPanel.add(new JLabel("Perwalian:"), gbc);

        gbc.gridx = 1;
        receiveNotifCheckBox = new JCheckBox("Yes");
        inputPanel.add(receiveNotifCheckBox, gbc);

        // Add Button
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add Mata Kuliah");
        addButton.addActionListener(new AddEnrollmentAction());
        inputPanel.add(addButton, gbc);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void setupEnrollmentTable() {
        String[] columnNames = {"Name", "NPM", "Jurusan", "Kelas", "Semester", "Status", 
            "Jenis Kelamin", "Comments", "Perwalian"};
        tableModel = new DefaultTableModel(columnNames, 0);
        enrollmentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(enrollmentTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Mata Kuliah List"));
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupStudentList() {
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        studentList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedStudent = studentList.getSelectedValue();
                    JOptionPane.showMessageDialog(null, "Selected Student: " + selectedStudent);
                }
            }
        });

        JScrollPane listScrollPane = new JScrollPane(studentList);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("List Mahasiswa"));
        add(listScrollPane, BorderLayout.EAST);
    }

    private class AddEnrollmentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String npm = npmField.getText();
            String course = (String) courseComboBox.getSelectedItem();
            String kelas = (String) classSpinner.getValue();
            int semester = semesterSlider.getValue();
            String status = (String) statusComboBox.getSelectedItem();
            String gender = maleRadioButton.isSelected() ? "Laki-laki" : "Perempuan";
            String comments = commentsArea.getText();
            String notifications = receiveNotifCheckBox.isSelected() ? "Yes" : "No";

            if (!name.isEmpty() && !npm.isEmpty() && course != null) {
                // Add to table
                tableModel.addRow(new Object[]{name, npm, course, kelas, semester, 
                    status, gender, comments, notifications});

                // Add to student list
                listModel.addElement(name);

                // Clear form fields
                clearFormFields();
            } else {
                JOptionPane.showMessageDialog(null, "Mohon isi kolom yang kosong");
            }
        }

        private void clearFormFields() {
            nameField.setText("");
            npmField.setText("");
            courseComboBox.setSelectedIndex(0);
            classSpinner.setValue("A");
            semesterSlider.setValue(1);
            statusComboBox.setSelectedIndex(0);
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            commentsArea.setText("");
            receiveNotifCheckBox.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormMataKuliah app = new FormMataKuliah();
            app.setVisible(true);
        });
    }
}
