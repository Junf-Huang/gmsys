package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Department;
import com.exercise.gmsys.model.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProviderMapper {
    int deleteByPrimaryKey(Integer PROVID);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer PROVID);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);

    List<Provider> findAll();

    List<Provider> findByKeyword(String keyword);
}