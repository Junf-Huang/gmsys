package com.exercise.gmsys.impl;

import com.exercise.gmsys.mapper.CategoryMapper;
import com.exercise.gmsys.model.Category;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class CategoryServiceImp {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> findAll(int pageNum, int pageSize){

        PageHelper.startPage(pageNum, pageSize);
        return categoryMapper.findAll();
    }

}
