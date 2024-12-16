package model;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ProductMapper {
    @Select("SELECT * FROM products")
    List<Product> getAllProducts();

    @Insert("INSERT INTO products(name, category, price, stock) VALUES (#{name}, #{category}, #{price}, #{stock})")
    void insertProduct(Product product);

    @Update("UPDATE products SET name=#{name}, category=#{category}, price=#{price}, stock=#{stock} WHERE id=#{id}")
    void updateProduct(Product product);

    @Delete("DELETE FROM products WHERE id=#{id}")
    void deleteProduct(int id);
}