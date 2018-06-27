package com.exercise.gmsys.controller;

import com.exercise.gmsys.impl.CategoryServiceImp;
import com.exercise.gmsys.model.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class BasciDataController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/category/findAll")
    public String findAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize, Model model){
        //pageNum为第几页，pageSize为每页记录条数
        PageInfo<Category> pageInfo = categoryServiceImp.findAll(pageNum, pageSize);

        log.info("page={}", pageInfo.getPages());

        model.addAttribute("data", pageInfo.getList());

        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "files/zcfldetails";
       //return  categoryServiceImp.findAll(pageNum, pageSize).toString();
    }
}
