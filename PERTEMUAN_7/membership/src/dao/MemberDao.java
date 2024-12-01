package PERTEMUAN_7.membership.src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import PERTEMUAN_7.membership.src.db.MySqlConnection;
import PERTEMUAN_7.membership.src.model.JenisMember;
import PERTEMUAN_7.membership.src.model.Member;


public class MemberDao {
    // Insert a new member
    public int insert(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String sql = "INSERT INTO member (id, nama, jenis_member_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getJenisMember().getId());
            
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update an existing member
    public int update(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String sql = "UPDATE member SET nama = ?, jenis_member_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, member.getNama());
            statement.setString(2, member.getJenisMember().getId());
            statement.setString(3, member.getId());
            
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete a member
    public int delete(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String sql = "DELETE FROM member WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, member.getId());
            
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Find all members with their corresponding JenisMember
    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String sql = "SELECT member.id, member.nama, jenis_member.id jenis_member_id, jenis_member.nama jenis_member_nama " +
                        "FROM member JOIN jenis_member ON jenis_member.id = member.jenis_member_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getString("id"));
                member.setNama(resultSet.getString("nama"));
                
                JenisMember jenisMember = new JenisMember();
                jenisMember.setId(resultSet.getString("jenis_member_id"));
                jenisMember.setNama(resultSet.getString("jenis_member_nama"));
                
                member.setJenisMember(jenisMember);
                list.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}