package com.exercise.gmsys.impl;

import com.exercise.gmsys.mapper.CategoryMapper;
import com.exercise.gmsys.model.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class CategoryServiceImp {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> findAll(){

        return categoryMapper.findAll();
    }

    public Category findById(Integer cid){
        return categoryMapper.selectByPrimaryKey(cid);
    }

    public void update(Category category){
        categoryMapper.updateByPrimaryKey(category);
    }

    public void insert(Category category){
        categoryMapper.insert(category);
    }

    public void delete(Integer CID) {
        categoryMapper.deleteByPrimaryKey(CID);
    }

    public List<Category> findByKeyword(String keyword) {

        return categoryMapper.findByKeyword(keyword);
    }

}
