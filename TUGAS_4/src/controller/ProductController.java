package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.session.SqlSession;

import model.*;
import view.ProductView;

public class ProductController {
    private ProductView view;
    private ProductMapper mapper;

    public ProductController(ProductView view, ProductMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        this.view.addAddProductListener(new AddProductListener());
        this.view.addUpdateProductListener(new UpdateProductListener());
        this.view.addDeleteProductListener(new DeleteProductListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addTableSelectionListener(new TableSelectionListener());

        loadData();
    }

    // Menambah produk baru
    class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Product product = new Product();
                product.setName(view.getNameInput());
                product.setCategory(view.getCategoryInput());
                product.setPrice(view.getPriceInput());
                product.setStock(view.getStockInput());

                mapper.insertProduct(product);
                JOptionPane.showMessageDialog(view, "Product added successfully!");
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        }
    }

    // Mengupdate produk yang dipilih
    class UpdateProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Please select a product to update.");
                    return;
                }

                int id = (int) view.getTable().getValueAt(selectedRow, 0);

                Product product = new Product();
                product.setId(id);
                product.setName(view.getNameInput());
                product.setCategory(view.getCategoryInput());
                product.setPrice(view.getPriceInput());
                product.setStock(view.getStockInput());

                mapper.updateProduct(product);
                JOptionPane.showMessageDialog(view, "Product updated successfully!");
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        }
    }

    // Menghapus produk yang dipilih
    class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Please select a product to delete.");
                    return;
                }
    
                int id = (int) view.getTable().getValueAt(selectedRow, 0);
    
                // Menghapus produk dari database
                mapper.deleteProduct(id);
    
                // Mendapatkan SqlSession untuk commit dan membersihkan cache
                SqlSession session = MyBatisUtil.getSqlSession();
    
                // Membersihkan cache MyBatis
                session.clearCache();  // Membersihkan cache untuk data yang telah dihapus
    
                // Commit untuk menyimpan perubahan di database
                session.commit();
    
                JOptionPane.showMessageDialog(view, "Product deleted successfully!");
    
                // Memuat ulang data di view setelah perubahan
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        }
    }
    


    // Memuat ulang data ke tabel
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadData();  // Memuat ulang data dari database setelah delete
        }
    }
    

    // Mengisi form ketika baris di tabel dipilih
    class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow != -1) {
                view.setNameInput(view.getTable().getValueAt(selectedRow, 1).toString());
                view.setCategoryInput(view.getTable().getValueAt(selectedRow, 2).toString());
                view.setPriceInput(Double.parseDouble(view.getTable().getValueAt(selectedRow, 3).toString()));
                view.setStockInput(Integer.parseInt(view.getTable().getValueAt(selectedRow, 4).toString()));
            }
        }
    }

    // Fungsi untuk memuat data produk ke tabel
    private void loadData() {
        try {
            // Ambil data terbaru dari database setelah delete
            List<Product> products = mapper.getAllProducts();
            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Category", "Price", "Stock"}, 0);
    
            for (Product p : products) {
                tableModel.addRow(new Object[]{p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getStock()});
            }
    
            view.getTable().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
        }
    }    
}