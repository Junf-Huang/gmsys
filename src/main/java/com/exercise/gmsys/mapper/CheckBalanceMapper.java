package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.CheckBalance;
import com.exercise.gmsys.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CheckBalanceMapper {
    int deleteByPrimaryKey(Integer CHID);

    int insert(CheckBalance record);

    int insertSelective(CheckBalance record);

    CheckBalance selectByPrimaryKey(Integer CHID);

    int updateByPrimaryKeySelective(CheckBalance record);

    int updateByPrimaryKey(CheckBalance record);

    List<CheckBalance> findAll();

    List<CheckBalance> findByKeyword(String keyword);
}