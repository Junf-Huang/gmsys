package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Scrap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScrapMapper {
    int deleteByPrimaryKey(Integer SID);

    int insert(Scrap record);

    int insertSelective(Scrap record);

    Scrap selectByPrimaryKey(Integer SID);

    int updateByPrimaryKeySelective(Scrap record);

    int updateByPrimaryKey(Scrap record);

    List<Scrap> findAll();

    List<Scrap> findByKeyword(String keyword);
}