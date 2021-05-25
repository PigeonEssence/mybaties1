package cn.itsource.mapper;

import cn.itsource.domain.Students;
import cn.itsource.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudnetsMapper {
    /**=================================================
     * 方法说明:通过id查找
     * 步骤说明：
     =================================================== **/
    Students selectById(Long id);

}
