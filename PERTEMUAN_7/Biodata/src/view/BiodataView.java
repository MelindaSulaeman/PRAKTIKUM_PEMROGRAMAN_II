package Biodata.src.view;

import Biodata.src.dao.BiodataDao;
import Biodata.src.model.Biodata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BiodataView extends JFrame {
    private final BiodataDao biodataDao;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtId, txtNama, txtAlamat;
    private JButton btnAdd, btnUpdate, btnDelete;

    public BiodataView() {
        biodataDao = new BiodataDao();
        initComponents();
        loadBiodataData();
    }

    private void initComponents() {
        setTitle("Aplikasi Biodata");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(3, 2));
        panelInput.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelInput.add(txtId);

        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Alamat:"));
        txtAlamat = new JTextField();
        panelInput.add(txtAlamat);

        // Panel Tombol
        JPanel panelButtons = new JPanel();
        btnAdd = new JButton("Tambah");
        btnUpdate = new JButton("Perbarui");
        btnDelete = new JButton("Hapus");

        panelButtons.add(btnAdd);
        panelButtons.add(btnUpdate);
        panelButtons.add(btnDelete);

        // Panel Tabel
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "Alamat"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout Utama
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Event Listener untuk Tombol
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBiodata();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBiodata();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBiodata();
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> fillInputFields());
    }

    private void loadBiodataData() {
        List<Biodata> biodataList = biodataDao.getAllBiodata();
        tableModel.setRowCount(0); // Hapus data lama

        for (Biodata biodata : biodataList) {
            tableModel.addRow(new Object[]{biodata.getId(), biodata.getNama(), biodata.getAlamat()});
        }
    }

    private void addBiodata() {
        Biodata biodata = new Biodata();
        biodata.setId(txtId.getText());
        biodata.setNama(txtNama.getText());
        biodata.setAlamat(txtAlamat.getText());

        biodataDao.addBiodata(biodata);
        loadBiodataData(); // Refresh tabel
        clearInputFields();
    }

    private void updateBiodata() {
        Biodata biodata = new Biodata();
        biodata.setId(txtId.getText());
        biodata.setNama(txtNama.getText());
        biodata.setAlamat(txtAlamat.getText());

        biodataDao.updateBiodata(biodata);
        loadBiodataData(); // Refresh tabel
        clearInputFields();
    }

    private void deleteBiodata() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            biodataDao.deleteBiodata(id);
            loadBiodataData(); // Refresh tabel
            clearInputFields();
        }
    }

    private void fillInputFields() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtId.setText((String) tableModel.getValueAt(selectedRow, 0));
            txtNama.setText((String) tableModel.getValueAt(selectedRow, 1));
            txtAlamat.setText((String) tableModel.getValueAt(selectedRow, 2));
        }
    }

    private void clearInputFields() {
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BiodataView().setVisible(true));
    }
}
