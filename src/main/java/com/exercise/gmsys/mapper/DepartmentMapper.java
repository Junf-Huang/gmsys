package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer DEPARTID);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer DEPARTID);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);


    List<Department> findAll();

    List<Department> findByKeyword(String keyword);
}