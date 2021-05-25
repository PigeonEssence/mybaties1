package cn.itsource.mapper;

import cn.itsource.domain.Dept;

public interface DeptMapper {
    Dept selectById(Long id);

    void insert(Dept dept);
}
