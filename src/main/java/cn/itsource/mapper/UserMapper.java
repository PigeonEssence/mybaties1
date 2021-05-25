package cn.itsource.mapper;

import cn.itsource.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**=================================================
     * 方法说明:通过id查找
     * 步骤说明：
     =================================================== **/
    User selectById(Long id);
    User selectById2(Long id);
    /**=================================================
     * 方法说明:批量删除
     * 步骤说明：
     *  void deleByIds(@Param(idList) List<Long> idList);
     *  @ Param可以自定义list的别名
     =================================================== **/
    void deleByIds(@Param("idList") List<Long> idList);

    /**=================================================
     * 方法说明:批量增加
     * 步骤说明：
     * @ Param可以自定义list的别名
     =================================================== **/
    void insertUsers(@Param("userList") List<User> userList);
    void insert(User user);


    void updateById(User user);
}
