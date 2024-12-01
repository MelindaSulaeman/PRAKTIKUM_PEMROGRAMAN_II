package Biodata.src.dao;

import Biodata.src.model.Biodata;
import Biodata.src.db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BiodataDao {
    private final Connection connection;

    public BiodataDao() {
        this.connection = MySqlConnection.getConnection();
    }

    // Menambahkan data biodata baru
    public void addBiodata(Biodata biodata) {
        String query = "INSERT INTO biodata (id, nama, alamat) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getAlamat());
            statement.executeUpdate();
            System.out.println("Data biodata berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua data biodata
    public List<Biodata> getAllBiodata() {
        List<Biodata> biodataList = new ArrayList<>();
        String query = "SELECT * FROM biodata";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Biodata biodata = new Biodata();
                biodata.setId(resultSet.getString("id"));
                biodata.setNama(resultSet.getString("nama"));
                biodata.setAlamat(resultSet.getString("alamat"));
                biodataList.add(biodata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodataList;
    }

    // Memperbarui data biodata
    public void updateBiodata(Biodata biodata) {
        String query = "UPDATE biodata SET nama = ?, alamat = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getAlamat());
            statement.setString(3, biodata.getId());
            statement.executeUpdate();
            System.out.println("Data biodata berhasil diperbarui!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus data biodata berdasarkan ID
    public void deleteBiodata(String id) {
        String query = "DELETE FROM biodata WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
            System.out.println("Data biodata berhasil dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
