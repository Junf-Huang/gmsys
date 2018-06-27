package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer AREAID);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer AREAID);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}