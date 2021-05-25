package cn.itsource;

import cn.itsource.domain.Dept;
import cn.itsource.domain.User;
import cn.itsource.mapper.DeptMapper;
import cn.itsource.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class DeptTest {
    @Test
    public void findOne() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        DeptMapper mapper = session.getMapper(DeptMapper.class);

        System.out.println(mapper);
        Dept dept = mapper.selectById(1L);

        System.out.println(dept);
    }
}
