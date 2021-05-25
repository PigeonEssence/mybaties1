package cn.itsource;

import cn.itsource.domain.Students;
import cn.itsource.domain.User;
import cn.itsource.mapper.StudnetsMapper;
import cn.itsource.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class StudentsTest {
    @Test
    public void findOne() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        StudnetsMapper mapper = session.getMapper(StudnetsMapper.class);

        System.out.println(mapper);
        Students stu = mapper.selectById(2L);

        System.out.println(stu);
        System.out.println(stu.getClasses());
    }
}
