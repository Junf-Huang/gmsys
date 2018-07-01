package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Provider;
import com.exercise.gmsys.model.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RepairMapper {
    int deleteByPrimaryKey(Integer REPAIRID);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer REPAIRID);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);

    List<Repair> findAll();

    List<Repair> findByKeyword(String keyword);
}