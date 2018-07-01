package com.exercise.gmsys.controller;

import com.exercise.gmsys.imp.*;
import com.exercise.gmsys.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class RecordController {
    @Autowired
    RepairServiceImp repairServiceImp;

    @Autowired
    ScrapServiceImp scrapServiceImp;

    @Autowired
    AssignmentServiceImp assignmentServiceImp;

    @Autowired
    BuyServiceImp buyServiceImp;

    @Autowired
    AssetServiceImp assetServiceImp;

    @GetMapping("/asset/record")
    public String findAsset(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Asset> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {
            pageInfo = new PageInfo<>(assetServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(assetServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "usageStatistics/totalAsset";
    }

    @GetMapping("/purchase/record")
    public String findPurchase(@RequestParam(defaultValue = "") String keyword,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Buy> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {
            pageInfo = new PageInfo<>(buyServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(buyServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "usageStatistics/purchaseList";
    }

    @GetMapping("/assignment/record")
    public String findAssignment(@RequestParam(defaultValue = "") String keyword,
                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Assignment> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {
            pageInfo = new PageInfo<>(assignmentServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(assignmentServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "usageStatistics/assignmentList";
    }

    @GetMapping("/repair/record")
    public String findRepair(@RequestParam(defaultValue = "") String keyword,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Repair> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {

            pageInfo = new PageInfo<>(repairServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(repairServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "usageStatistics/repairList";
    }

    @GetMapping("/scrap/record")
    public String findScrap(@RequestParam(defaultValue = "") String keyword,
                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Scrap> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {

            pageInfo = new PageInfo<>(scrapServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(scrapServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "usageStatistics/scrapList";
    }
}
