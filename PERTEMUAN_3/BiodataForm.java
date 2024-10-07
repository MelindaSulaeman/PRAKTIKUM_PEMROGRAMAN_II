package PERTEMUAN_3;

import java.awt.*;
import javax.swing.*;

public class BiodataForm extends JFrame {

    public BiodataForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata");

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5); // Adding padding between components

        JLabel nameLabel = new JLabel("Nama:");
        JTextField nameField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        JRadioButton maleButton = new JRadioButton("Laki-Laki");
        JRadioButton femaleButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(maleButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(femaleButton, gbc);

        JLabel phoneLabel = new JLabel("Nomor HP:");
        JTextField phoneField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(phoneField, gbc);

        JCheckBox foreignCheckBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(foreignCheckBox, gbc);

        JButton submitButton = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        this.setLayout(new GridLayout(2, 1));
        this.add(headerLabel);
        this.add(panel);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataForm form = new BiodataForm();
                form.setVisible(true);
            }
        });
    }
}
