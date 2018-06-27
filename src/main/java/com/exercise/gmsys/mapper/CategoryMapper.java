package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer CID);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer CID);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> findAll();
}