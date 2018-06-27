package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer DEPARTID);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer DEPARTID);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}