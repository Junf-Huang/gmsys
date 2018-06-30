package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.ScrapMapper;
import com.exercise.gmsys.model.Scrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapServiceImp {
    @Autowired
    ScrapMapper scrapMapper;

    public List<Scrap> findAll(){

        return scrapMapper.findAll();
    }

    public Scrap findById(Integer cid){
        return scrapMapper.selectByPrimaryKey(cid);
    }

    public void update(Scrap scrap){
        scrapMapper.updateByPrimaryKey(scrap);
    }

    public void insert(Scrap scrap){
        scrapMapper.insert(scrap);
    }

    public void delete(Integer ID) {
        scrapMapper.deleteByPrimaryKey(ID);
    }

    public List<Scrap> findByKeyword(String keyword) {

        return scrapMapper.findByKeyword(keyword);
    }
}
