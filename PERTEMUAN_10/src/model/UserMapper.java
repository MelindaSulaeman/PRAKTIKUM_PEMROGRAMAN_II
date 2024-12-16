package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();
    
    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    void insertUser(User user);
}