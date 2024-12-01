package PERTEMUAN_7.membership.src.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PERTEMUAN_7.membership.src.db.MySqlConnection;
import PERTEMUAN_7.membership.src.model.JenisMember;

public class JenisMemberDao {
    public int insert(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into jenis_member (id, nama) values (?, ?)");
            statement.setString(1, jenisMember.getId());
            statement.setString(2, jenisMember.getNama());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update jenis_member set nama = ? where id = ?");
            statement.setString(1, jenisMember.getNama());
            statement.setString(2, jenisMember.getId());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from jenis_member where id = ?");
            statement.setString(1, jenisMember.getId());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<JenisMember> findAll() {
    List<JenisMember> list = new ArrayList<>();
    try (Connection connection = MySqlConnection.getInstance().getConnection();
         Statement statement = connection.createStatement()) {
        try (ResultSet resultSet = statement.executeQuery("select * from jenis_member")) {
            // Retrieving the data
            while (resultSet.next()) {
                JenisMember jenisMember = new JenisMember();
                jenisMember.setId(resultSet.getString("id"));
                jenisMember.setNama(resultSet.getString("nama"));
                list.add(jenisMember);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
    }
}