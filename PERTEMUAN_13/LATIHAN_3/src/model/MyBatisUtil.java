package model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder() 
                    .build(Resources.getResourceAsStream ("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static SqlSession getSqlSession() { 
        return sqlSessionFactory.openSession(true);
    }
}
