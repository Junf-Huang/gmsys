package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.CheckBalanceMapper;
import com.exercise.gmsys.model.CheckBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckBalanceServiceImp {

    @Autowired
    CheckBalanceMapper checkBalanceMapper;

    public List<CheckBalance> findAll(){

        return checkBalanceMapper.findAll();
    }

    public CheckBalance findById(Integer id){
        return checkBalanceMapper.selectByPrimaryKey(id);
    }

    public void update(CheckBalance checkBalance){
        checkBalanceMapper.updateByPrimaryKey(checkBalance);
    }

    public void insert(CheckBalance checkBalance){
        checkBalanceMapper.insert(checkBalance);
    }

    public void delete(Integer id) {
        checkBalanceMapper.deleteByPrimaryKey(id);
    }

    public List<CheckBalance> findByKeyword(String keyword) {

        return checkBalanceMapper.findByKeyword(keyword);
    }
}
