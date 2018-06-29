package com.exercise.gmsys.controller;

import com.exercise.gmsys.impl.AreaServiceImp;
import com.exercise.gmsys.impl.AssetServiceImp;
import com.exercise.gmsys.impl.CategoryServiceImp;
import com.exercise.gmsys.impl.DepartmentServiceImp;
import com.exercise.gmsys.model.Area;
import com.exercise.gmsys.model.Asset;
import com.exercise.gmsys.model.Category;
import com.exercise.gmsys.model.Department;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class BasciDataController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @Autowired
    DepartmentServiceImp departmentServiceImp;

    @Autowired
    AssetServiceImp assetServiceImp;

    @Autowired
    AreaServiceImp areaServiceImp;

    @GetMapping("/category/list")
    public String findCategory(@RequestParam(defaultValue = "") String keyword,
                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Category> pageInfo;
        PageHelper.startPage(pageNum, pageSize);

        if(keyword.equals("")) {
            //pageNum为第几页，pageSize为每页记录条数
            pageInfo = new PageInfo<>(categoryServiceImp.findAll());
        } else {
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

        return "basicDataAdmin/categoryList";
       //return  categoryServiceImp.findAll(pageNum, pageSize).toString();
    }

    @GetMapping("/department/list")
    public String findDepartment(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Department> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {
            pageInfo = new PageInfo<>(departmentServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(departmentServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "basicDataAdmin/departmentList";
    }

    @GetMapping("/area/list")
    public String findArea(@RequestParam(defaultValue = "") String keyword,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Area> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {
            pageInfo = new PageInfo<>(areaServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(areaServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "basicDataAdmin/areaList";
    }

    @GetMapping("/category/findById")
    public String findCategoryById(Integer cid, Model model){
        model.addAttribute("category", categoryServiceImp.findById(cid));
        return "basicDataAdmin/categoryUpdate";
    }

    @GetMapping("/department/findById")
    public String findDepartmentById(Integer did, Model model){
        model.addAttribute("department", departmentServiceImp.findById(did));
        return "basicDataAdmin/departmentUpdate";
    }

    @GetMapping("/area/findById")
    public String findAreaById(Integer aid, Model model){
        model.addAttribute("area", areaServiceImp.findById(aid));
        return "basicDataAdmin/areaUpdate";
    }

    @PostMapping("/category/update")
    public String updateCategory(Category category){
        categoryServiceImp.update(category);
        return "redirect:/category/list";
    }

    @PostMapping("/department/update")
    public String updateDepartment(Department department){
        departmentServiceImp.update(department);
        return "redirect:/department/list";
    }

    @PostMapping("/area/update")
    public String updateArea(Area area){
        areaServiceImp.update(area);
        return "redirect:/area/list";
    }

    @PostMapping("/category/add")
    public String addCategory(Category category){
        categoryServiceImp.insert(category);
        return "redirect:/category/list";
    }

    @PostMapping("/department/add")
    public String addDepartment(Department department){
        departmentServiceImp.insert(department);
        return "redirect:/department/list";
    }

    @PostMapping("/asset/add")
    public String addAsset(Asset asset, String DATE) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(DATE);
        asset.setBDATE(date);
        assetServiceImp.insert(asset);
        return "/basicDataAdmin/assetAdd";
    }

    @PostMapping("/area/add")
    public String addArea(Area area){
        areaServiceImp.insert(area);
        return "redirect:/area/list";
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

    @GetMapping("/department/delete")
    public String deleteDepartment(String id) {
        String[]  ids = id.split(",");

        for (String id1 : ids) {
            log.info("cid={}", id1);
            departmentServiceImp.delete(Integer.valueOf(id1));
        }
        return "redirect:/department/list";
    }

    @GetMapping("/area/delete")
    public String deleteArea(String id) {
        String[]  ids = id.split(",");

        for (String id1 : ids) {
            log.info("cid={}", id1);
            areaServiceImp.delete(Integer.valueOf(id1));
        }
        return "redirect:/area/list";
    }

    @GetMapping("/department/findOne")
    public String findDepartment(Integer did, Model model){
        model.addAttribute("department", departmentServiceImp.findById(did));
        return "basicDataAdmin/departmentDetail";
    }


}
