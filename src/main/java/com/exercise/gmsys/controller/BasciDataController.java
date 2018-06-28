package com.exercise.gmsys.controller;

import com.exercise.gmsys.impl.CategoryServiceImp;
import com.exercise.gmsys.model.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class BasciDataController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/category/list")
    public String findCategory(@RequestParam(defaultValue = "") String keyword,
                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Category> pageInfo;

        if(keyword.equals("")) {
            //pageNum为第几页，pageSize为每页记录条数
            PageHelper.startPage(pageNum, pageSize);
            pageInfo = new PageInfo<>(categoryServiceImp.findAll());
        } else {
            PageHelper.startPage(pageNum, pageSize);
            pageInfo = new PageInfo<>(categoryServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

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

        return "category/categoryList";
       //return  categoryServiceImp.findAll(pageNum, pageSize).toString();
    }

    @GetMapping("/category/findById")
    public String findById(Integer cid, Model model){
        model.addAttribute("category", categoryServiceImp.findById(cid));
        return "category/updateCategory";
    }

    @PostMapping("/category/update")
    public String updateCategory(Category category){
        categoryServiceImp.update(category);
        return "redirect:/category/list";
    }

    @PostMapping("/category/add")
    public String addCategory(Category category){
        categoryServiceImp.insert(category);
        return "redirect:/category/list";
    }

    @GetMapping("/category/delete")
    public String deleteCategory(String cid) {
        String[]  cids = cid.split(",");

        for (String cid1 : cids) {
            log.info("cid={}", cid1);
            categoryServiceImp.delete(Integer.valueOf(cid1));
        }
        return "redirect:/category/list";
    }

}
