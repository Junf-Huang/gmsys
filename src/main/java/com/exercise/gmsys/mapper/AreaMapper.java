package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AreaMapper {
    int deleteByPrimaryKey(Integer AREAID);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer AREAID);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> findAll();

    List<Area> findByKeyword(String keyword);
}