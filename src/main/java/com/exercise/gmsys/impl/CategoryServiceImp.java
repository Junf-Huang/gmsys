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

    public PageInfo<Category> findAll(int pageNum, int pageSize){

        //对其后的第一个查询分页
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(categoryMapper.findAll());
    }

}
