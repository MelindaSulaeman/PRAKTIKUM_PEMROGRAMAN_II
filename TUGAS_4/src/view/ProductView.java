package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class ProductView extends JFrame {
    private JTextField txtName = new JTextField(20);
    private JTextField txtCategory = new JTextField(20);
    private JTextField txtPrice = new JTextField(20);
    private JTextField txtStock = new JTextField(20);
    private JButton btnAdd = new JButton("Add Product");
    private JButton btnUpdate = new JButton("Update Product");
    private JButton btnDelete = new JButton("Delete Product");
    private JButton btnRefresh = new JButton("Refresh");
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);

    public ProductView() {
        setTitle("Product Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(txtCategory);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(txtPrice);
        inputPanel.add(new JLabel("Stock:"));
        inputPanel.add(txtStock);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getNameInput() { return txtName.getText(); }
    public String getCategoryInput() { return txtCategory.getText(); }
    public double getPriceInput() { return Double.parseDouble(txtPrice.getText()); }
    public int getStockInput() { return Integer.parseInt(txtStock.getText()); }

    public JTable getTable() { return table; }

    public void setNameInput(String name) { txtName.setText(name); }
    public void setCategoryInput(String category) { txtCategory.setText(category); }
    public void setPriceInput(double price) { txtPrice.setText(String.valueOf(price)); }
    public void setStockInput(int stock) { txtStock.setText(String.valueOf(stock)); }

    public void addAddProductListener(ActionListener listener) { btnAdd.addActionListener(listener); }
    public void addUpdateProductListener(ActionListener listener) { btnUpdate.addActionListener(listener); }
    public void addDeleteProductListener(ActionListener listener) { btnDelete.addActionListener(listener); }
    public void addRefreshListener(ActionListener listener) { btnRefresh.addActionListener(listener); }
    public void addTableSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}