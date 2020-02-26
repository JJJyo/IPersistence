import com.lagou.dao.IUserDao;
import com.lagou.io.Resource;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public class IPersistenceTest {


    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(3);
        user.setUsername("张三");

        User user2 = new User();
        user2.setId(2);

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("李四");
//        User user1 = sqlSession.selectOne("user.findByCondition", user);
//        System.out.println(user1.getUsername());
//
//        List<User> users = sqlSession.selectList("user.findAll");
//        for (User user2 : users) {
//            System.out.println(user2.getUsername());
//        }
//    }

        //返回代理對象，代理對象執行invoke方法
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

//        List<User> all = userDao.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }
        userDao.insert(user);
//        userDao.deleteById(user2);
//        userDao.updateById(user3);
    }
}
