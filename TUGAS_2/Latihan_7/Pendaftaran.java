package TUGAS_2.Latihan_7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Pendaftaran extends JFrame implements ActionListener, ItemListener {
    private JTextField kotakNama;
    private JTextField kotakNoHp;
    private JButton tombol;
    private JTextArea areaBiodata;
    private JCheckBox checkBox;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private ButtonGroup bg;
    private boolean isCheckBoxSelected;

    public Pendaftaran() {
        this.setTitle("PERTEMUAN 2 - LATIHAN 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);

        JLabel LabelNama = new JLabel("Nama :");
        LabelNama.setBounds(15, 20, 100, 30);
        kotakNama = new JTextField();
        kotakNama.setBounds(80, 20, 200, 30);

        JLabel LabelNoHp = new JLabel("Nomor Hp :");
        LabelNoHp.setBounds(15, 60, 100, 30);
        kotakNoHp = new JTextField();
        kotakNoHp.setBounds(80, 60, 200, 30);

        JLabel jenisKelamin = new JLabel("Jenis Kelamin : ");
        jenisKelamin.setBounds(15, 90, 100, 30);
        radio1 = new JRadioButton("Laki-Laki");
        radio1.setBounds(15, 115, 350, 30);
        radio2 = new JRadioButton("Perempuan");
        radio2.setBounds(15, 145, 350, 30);
        bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);

        checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 175, 350, 30);
        checkBox.addItemListener(this);

        tombol = new JButton("Simpan");
        tombol.setBounds(15, 400, 100, 30);
        tombol.addActionListener(this);

        areaBiodata = new JTextArea("");
        areaBiodata.setBounds(15, 240, 300, 150);
        areaBiodata.setEditable(false);

        add(LabelNama);
        add(kotakNama);
        add(LabelNoHp);
        add(kotakNoHp);
        add(jenisKelamin);
        add(radio1);
        add(radio2);
        add(checkBox);
        add(tombol);
        add(areaBiodata);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        isCheckBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = kotakNama.getText();
        String noHp = kotakNoHp.getText();
        String JK = "";

        if (radio1.isSelected()) {
            JK = radio1.getText();
        } else if (radio2.isSelected()) {
            JK = radio2.getText();
        }

        String wnaStatus;
        if (isCheckBoxSelected) {
            wnaStatus = "WNA : Ya";
        } else {
            wnaStatus = "WNA : Bukan";
        }

        String biodata = "Nama: " + nama + "\nNomor Telepon: " + noHp + "\n" + "Jenis Kelamin : " + JK + "\n" + wnaStatus + "\n" + "=".repeat(30) + "\n";

        areaBiodata.append(biodata);

        kotakNama.setText("");
        kotakNoHp.setText("");
        bg.clearSelection(); // Clear radio button selection
        checkBox.setSelected(false); // Uncheck checkbox
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Pendaftaran();
        });
    }
}
