package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Buy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuyMapper {
    int deleteByPrimaryKey(Integer BUYID);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(Integer BUYID);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);

    List<Buy> findAll();

    List<Buy> findByKeyword(String keyword);
}