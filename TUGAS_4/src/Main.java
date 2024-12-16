import controller.ProductController;
import model.MyBatisUtil;
import model.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import view.ProductView;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);

        ProductView view = new ProductView();
        new ProductController(view, mapper);

        view.setVisible(true);
    }
}