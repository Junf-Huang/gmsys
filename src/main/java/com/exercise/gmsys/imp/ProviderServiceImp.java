package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.ProviderMapper;
import com.exercise.gmsys.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImp {

    @Autowired
    ProviderMapper providerMapper;

    public List<Provider> findAll(){

        return providerMapper.findAll();
    }

    public Provider findById(Integer id){
        return providerMapper.selectByPrimaryKey(id);
    }

    public void update(Provider provider){
        providerMapper.updateByPrimaryKey(provider);
    }

    public void insert(Provider provider){
        providerMapper.insert(provider);
    }

    public void delete(Integer id) {
        providerMapper.deleteByPrimaryKey(id);
    }

    public List<Provider> findByKeyword(String keyword) {

        return providerMapper.findByKeyword(keyword);
    }
}
