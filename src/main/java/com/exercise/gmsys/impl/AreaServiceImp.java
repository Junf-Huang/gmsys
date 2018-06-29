package com.exercise.gmsys.impl;

import com.exercise.gmsys.mapper.AreaMapper;
import com.exercise.gmsys.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp {

    @Autowired
    AreaMapper areaMapper;

    public List<Area> findAll(){

        return areaMapper.findAll();
    }

    public Area findById(Integer cid){
        return areaMapper.selectByPrimaryKey(cid);
    }

    public void update(Area area){
        areaMapper.updateByPrimaryKey(area);
    }

    public void insert(Area area){
        areaMapper.insert(area);
    }

    public void delete(Integer CID) {
        areaMapper.deleteByPrimaryKey(CID);
    }

    public List<Area> findByKeyword(String keyword) {

        return areaMapper.findByKeyword(keyword);
    }
}
