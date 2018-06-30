package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.AssetMapper;
import com.exercise.gmsys.model.Asset;
import com.exercise.gmsys.model.Buy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class AssetServiceImp {

    @Autowired
    AssetMapper assetMapper;

    @Autowired
    CategoryServiceImp categoryServiceImp;

    public List<Asset> findAll(){

        List<Asset> assets = assetMapper.findAll();
        for (Asset asset : assets) {
            asset.setCategoryName(categoryServiceImp.findById(asset.getCID()).getCNAME());
            log.info("productId={}", asset.getCategoryName());
        }
        return assets;
    }

    public Asset findById(Integer aid){
        Asset asset = assetMapper.selectByPrimaryKey(aid);
        asset.setCategoryName(categoryServiceImp.findById(asset.getCID()).getCNAME());
        return asset;
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
