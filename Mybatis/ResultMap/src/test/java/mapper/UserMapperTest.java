package mapper;

import com.halo.mapper.UserMapper;
import com.halo.pojo.User;
import com.halo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


/**
 * @author Halo
 * @date Created in 2020/11/07  11:26
 * @description
 */
public class UserMapperTest {


    @Test
    /**
     * 测试getUserByID方法
     */
    public void testGetUserByID() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user2 = mapper.getUserByID(2);
        System.out.println("user2 = " + user2);

        // 关闭 sqlSession
        sqlSession.close();
    }

}
