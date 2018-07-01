package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Asset;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AssetMapper {
    int deleteByPrimaryKey(Integer BID);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer BID);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);

    List<Asset> findAll();

    List<Asset> findByKeyword(String keyword);
}