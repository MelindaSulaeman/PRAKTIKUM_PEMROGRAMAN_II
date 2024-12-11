package model;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserMapper {
  @Select("SELECT * FROM users")
  List<User> getAllUsers();

  @Insert("INSERT INTO users(name, email) VALUES (#{name}, #{email})")
  void insertUser(User user);
}
