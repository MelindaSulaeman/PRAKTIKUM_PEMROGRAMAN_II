package LATIHAN_1;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        //Membuat frame utama
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            //Label untuk status
            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

            //Tombol untuk memulai proses
            JButton startButton = new JButton("Mulai");

            //Progress bar
            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            //Tambahkan komponen ke frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            //Tombol aksi
            startButton.addActionListener(e -> {
                //update progress bar 1% per detik
                for (int i = 0; i <= 60; i++) {
                    progressBar.setValue(i);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            });

            //Tampilkan frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}