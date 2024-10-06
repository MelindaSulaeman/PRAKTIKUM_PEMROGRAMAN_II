package TUGAS_2.Latihan_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MFrame extends JFrame implements ActionListener {
    private JTextField kotakNama;
    private JTextField kotakNoHp;
    private JButton tombol;
    private JTextArea areaBiodata;

    public MFrame() {
        this.setTitle("TUGAS 2 - Latihan_4");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(null);

        JLabel LabelNama = new JLabel("Nama :");
        LabelNama.setBounds(50, 20, 100, 30);
        kotakNama = new JTextField();
        kotakNama.setBounds(120, 20, 200, 30);

        JLabel LabelNoHp = new JLabel("No Handphone :");
        LabelNoHp.setBounds(50, 50, 100, 30);
        kotakNoHp = new JTextField();
        kotakNoHp.setBounds(120, 50, 200, 30);
        tombol = new JButton("Save");
        tombol.setBounds(120, 80, 100, 30);
        tombol.addActionListener(this);

        areaBiodata = new JTextArea();
        areaBiodata.setBounds(50, 130, 300, 250);
        areaBiodata.setEditable(false);

        add(LabelNama);
        add(kotakNama);
        add(LabelNoHp);
        add(kotakNoHp);
        add(tombol);
        add(areaBiodata);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = kotakNama.getText();
        String noHp = kotakNoHp.getText();

        String biodata = "Nama: " + nama + "\nNomor Telepon: " + noHp + "\n" + "=".repeat(30) + "\n";

        areaBiodata.append(biodata);

        kotakNama.setText("");
        kotakNoHp.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MFrame();
        });
    }
}
