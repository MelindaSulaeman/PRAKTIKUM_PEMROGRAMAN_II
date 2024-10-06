package TUGAS_2.Latihan_7_Modify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class FormPendaftaran extends JFrame {

    private JTextArea textAreaOutput;

    public FormPendaftaran() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Nama
        JPanel panelNama = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNama = new JLabel("Nama: ");
        JTextField textFieldNama = new JTextField(20);
        panelNama.add(labelNama);
        panelNama.add(textFieldNama);
        panel.add(panelNama);

        // Nomor Handphone
        JPanel panelHp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelHp = new JLabel("Nomor HP: ");
        JTextField textFieldHp = new JTextField(20);
        panelHp.add(labelHp);
        panelHp.add(textFieldHp);
        panel.add(panelHp);

        // Jenis Kelamin
        JPanel panelKelamin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelKelamin = new JLabel("Jenis Kelamin: ");
        JRadioButton radioButtonLaki = new JRadioButton("Laki-laki", true);
        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan");
        ButtonGroup groupKelamin = new ButtonGroup();
        groupKelamin.add(radioButtonLaki);
        groupKelamin.add(radioButtonPerempuan);
        panelKelamin.add(labelKelamin);
        panelKelamin.add(radioButtonLaki);
        panelKelamin.add(radioButtonPerempuan);
        panel.add(panelKelamin);

        // WNA
        JPanel panelWNA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelWNA = new JLabel("Warga Negara Asing: ");
        JCheckBox checkBoxWNA = new JCheckBox();
        panelWNA.add(labelWNA);
        panelWNA.add(checkBoxWNA);
        panel.add(panelWNA);

        //Jenis tabungan
        JPanel panelTabungan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTabungan = new JLabel("Jenis Tabungan: ");
        String[] tabunganOptions = {"Tabungan Rencana Pendidikan", "Tabungan Investasi", "Tabungan Traveling", "Tabungan Rumah"};
        JList<String> listTabungan = new JList<>(tabunganOptions);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listTabungan);
        scrollPane.setPreferredSize(new Dimension(200, 60));
        panelTabungan.add(labelTabungan);
        panelTabungan.add(scrollPane);
        panel.add(panelTabungan);

        //Frekuensi Transaksi
        JPanel panelTransaksi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi: ");
        JSpinner spinnerTransaksi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panelTransaksi.add(labelTransaksi);
        panelTransaksi.add(spinnerTransaksi);
        panel.add(panelTransaksi);

        //Password
        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPassword = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        panelPassword.add(labelPassword);
        panelPassword.add(passwordField);
        panel.add(panelPassword);

        JPanel panelConfirmPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password: ");
        JPasswordField confirmPasswordField = new JPasswordField(20);
        panelConfirmPassword.add(labelConfirmPassword);
        panelConfirmPassword.add(confirmPasswordField);
        panel.add(panelConfirmPassword);

        //Tanggal Lahir
        JPanel panelTanggalLahir = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir: ");
        Calendar calendar = Calendar.getInstance();
        SpinnerDateModel dateModel = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.YEAR);
        JSpinner spinnerTanggalLahir = new JSpinner(dateModel);
        spinnerTanggalLahir.setEditor(new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"));
        panelTanggalLahir.add(labelTanggalLahir);
        panelTanggalLahir.add(spinnerTanggalLahir);
        panel.add(panelTanggalLahir);

        textAreaOutput = new JTextArea(10, 30);
        textAreaOutput.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(textAreaOutput);
        panel.add(outputScrollPane);

        // Menu Simpan dan reset dan Exit
        JButton buttonSimpan = new JButton("Simpan");
        panel.add(buttonSimpan);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHp = textFieldHp.getText();
                String jenisKelamin = radioButtonLaki.isSelected() ? "Laki-laki" : "Perempuan";
                String wargaNegaraAsing = checkBoxWNA.isSelected() ? "Ya" : "Tidak";
                String jenisTabungan = listTabungan.getSelectedValue();
                int frekuensiTransaksi = (int) spinnerTransaksi.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                String passwordMessage = password.equals(confirmPassword) ? "Password benar" : "Password yang anda masukan salah";
                String tanggalLahir = ((JSpinner.DateEditor) spinnerTanggalLahir.getEditor()).getFormat().format(spinnerTanggalLahir.getValue());

                textAreaOutput.append("=== Data Diri ===\n");
                textAreaOutput.append("Nama: " + nama + "\n");
                textAreaOutput.append("Nomor HP: " + nomorHp + "\n");
                textAreaOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                textAreaOutput.append("Warga Negara Asing: " + wargaNegaraAsing + "\n");
                textAreaOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                textAreaOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + "\n");
                textAreaOutput.append("Tanggal Lahir: " + tanggalLahir + "\n");
                textAreaOutput.append(passwordMessage + "\n");
                textAreaOutput.append("====================\n\n");
            }
        });

        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldHp.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                listTabungan.clearSelection();
                spinnerTransaksi.setValue(1);
                spinnerTanggalLahir.setValue(calendar.getTime());
                checkBoxWNA.setSelected(false);
                textAreaOutput.setText("");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(panel);

        this.setTitle("Form Pendaftaran Nasabah Bank");
        this.setSize(400, 700);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormPendaftaran h = new FormPendaftaran();
                h.setVisible(true);
            }
        });
    }
}