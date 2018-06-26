package com.exercise.gmsys.controller;

import com.exercise.gmsys.impl.CategoryServiceImp;
import com.exercise.gmsys.model.Category;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BasciDataController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping("/category/findAll")
    @ResponseBody
    public String findAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Integer pageSize, Model model){
        model.addAttribute("data", categoryServiceImp.findAll(1,1));
        //return "files/zcfldetails";
        return  categoryServiceImp.findAll(1,1).toString();
    }
}
