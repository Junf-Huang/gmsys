package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Area;
import com.exercise.gmsys.model.Assignment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AssignmentMapper {
    int deleteByPrimaryKey(Integer TID);

    int insert(Assignment record);

    int insertSelective(Assignment record);

    Assignment selectByPrimaryKey(Integer TID);

    int updateByPrimaryKeySelective(Assignment record);

    int updateByPrimaryKey(Assignment record);

    List<Assignment> findAll();

    List<Assignment> findByKeyword(String keyword);
}