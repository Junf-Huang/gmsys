package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.RepairMapper;
import com.exercise.gmsys.model.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImp {

    @Autowired
    RepairMapper repairMapper;

    public List<Repair> findAll(){

        return repairMapper.findAll();
    }

    public Repair findById(Integer id){
        return repairMapper.selectByPrimaryKey(id);
    }

    public void update(Repair repair){
        repairMapper.updateByPrimaryKey(repair);
    }

    public void insert(Repair repair){
        repairMapper.insert(repair);
    }

    public void delete(Integer id) {
        repairMapper.deleteByPrimaryKey(id);
    }

    public List<Repair> findByKeyword(String keyword) {

        return repairMapper.findByKeyword(keyword);
    }
}
