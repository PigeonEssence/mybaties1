
package cn.itsource.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sessionFactory ;
    static{
        try {
            //提示处理异常快捷键    alt+回车       移动代码的快捷键  alt+上键或者下键
            //快速使用变量接收，    alt+回车
            InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
            //根据io流创建SqlSessionFactory对象
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession(){
        if (sessionFactory != null) {
            return sessionFactory.openSession();
        }
        return null;
    }
}
