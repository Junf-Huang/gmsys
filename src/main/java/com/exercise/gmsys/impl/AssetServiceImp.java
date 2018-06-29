package com.exercise.gmsys.impl;

import com.exercise.gmsys.mapper.AssetMapper;
import com.exercise.gmsys.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class AssetServiceImp {

    @Autowired
    AssetMapper assetMapper;

    public List<Asset> findAll(){

        return assetMapper.findAll();
    }

    public Asset findById(Integer aid){
        return assetMapper.selectByPrimaryKey(aid);
    }

    public void update(Asset asset){
        assetMapper.updateByPrimaryKey(asset);
    }

    public void insert(Asset asset){
        assetMapper.insert(asset);
    }

    public void delete(Integer aid) {
        assetMapper.deleteByPrimaryKey(aid);
    }

    public List<Asset> findByKeyword(String keyword) {

        return assetMapper.findByKeyword(keyword);
    }
}
