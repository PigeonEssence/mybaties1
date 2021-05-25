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
import java.util.Arrays;
import java.util.List;

public class UserTest {
    /**=================================================
     * 方法说明:
     * 1.加载配置文件，得到SqlSession
     * 2.使用SqlSession，获取到Mapper映射器
     * 3.调用UserMapper接口中的方法
     * 步骤说明：
     =================================================== **/
    @Test
    public void findOne() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper);
        User user = mapper.selectById(5L);

        System.out.println(user);
        System.out.println(user.getDept());
    }
    @Test
    public void findOne2() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper);
        User user = mapper.selectById2(5L);

        System.out.println(user);
        System.out.println(user.getDept());
    }
    /**=================================================
     * 方法说明:批量删除
     * 步骤说明：
     =================================================== **/
    @Test
    public void testDeleUsers() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<Long> idList= Arrays.asList(1L,2L,3L);
        userMapper.deleByIds(idList);
        session.commit();
        session.close();
    }
    /**=================================================
     * 方法说明:批量插入
     *      * 1.加载配置文件，得到SqlSession
     *      * 2.使用SqlSession，获取到Mapper映射器
     *      * 3.调用UserMapper接口中的tesInsertUsers方法
     * 步骤说明：
     =================================================== **/
 /*   @Test
    public void tesInsertUsers() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        *//*List<User> userList= Arrays.asList(
                new User("asas", "1111"),
                new User("cdcd", "2222"),
                new User("sdsd", "3333")
        );*//*
        userMapper.insertUsers(userList);
        session.commit();
        session.close();
    }*/
    /**=================================================
     * 方法说明:多對一保存
     * 步骤说明：
     =================================================== **/
    @Test
    public void testSaveUsers() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        DeptMapper deptMapper = session.getMapper(DeptMapper.class);

        Dept dept = new Dept("lololo");
        deptMapper.insert(dept);

        User user = new User("cjcj","12345",dept);
        userMapper.insert(user);
        session.commit();
        session.close();
    }

    /**=================================================
     * 方法说明:多對一修改
     * 步骤说明：
     =================================================== **/

    @Test
    public void testUpdateUsers() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession    使用session就可以跟数据库进行会话
        SqlSession session = sqlSessionFactory.openSession();

        // 调用UserMapper接口中的方法             代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        DeptMapper deptMapper = session.getMapper(DeptMapper.class);


        User user = userMapper.selectById(4L);
        user.setName("lopo");

        Dept dept =user.getDept();
        dept.setId(1L);

        user.setDept(dept);

        userMapper.updateById(user);
        session.commit();
        session.close();
    }
}
