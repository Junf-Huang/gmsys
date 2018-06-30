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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
@Controller
public class AssetController {

    @Autowired
    BuyServiceImp buyServiceImp;

    @Autowired
    ProviderServiceImp providerServiceImp;

    @Autowired
    ProductServiceImp productServiceImp;

    @Autowired
    AssignmentServiceImp assignmentServiceImp;

    @Autowired
    RepairServiceImp repairServiceImp;

    @Autowired
    ScrapServiceImp scrapServiceImp;

    @GetMapping("/purchase/list")
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

        return "assetAdmin/purchaseList";
    }

    @GetMapping("/assignment/list")
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

        return "assetAdmin/assignmentList";
    }

    @GetMapping("/repair/list")
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

        return "assetAdmin/repairList";
    }


    @GetMapping("/scrap/list")
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

        return "assetAdmin/scrapList";
    }

    @GetMapping("/purchase/findById")
    public String findPurchaseById(Integer bid, Model model){
        model.addAttribute("purchase", buyServiceImp.findById(bid));
        model.addAttribute("providers", providerServiceImp.findAll());
        model.addAttribute("products", productServiceImp.findAll());
        return "assetAdmin/purchaseUpdate";
    }

    @PostMapping("/purchase/update")
    public String updatePurchase(Buy buy, String DATE) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(DATE);
        buy.setBUYTIME(date);
        buyServiceImp.update(buy);
        return "redirect:/purchase/list";
    }

    @PostMapping("/purchase/add")
    public String addPurchase(Buy buy, String DATE) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(DATE);
        buy.setBUYTIME(date);
        buyServiceImp.insert(buy);
        return "redirect:/purchase/list";
    }

    @GetMapping("/purchase/delete")
    public String delete(String id) {
        String[]  cids = id.split(",");

        for (String cid1 : cids) {
            log.info("cid={}", cid1);
            buyServiceImp.delete(Integer.valueOf(cid1));
        }
        return "redirect:/purchase/list";
    }

    @GetMapping("/purchase/BeforeAdd")
    public String beforeAddPurchase(Model model) {
        model.addAttribute("providers", providerServiceImp.findAll());
        model.addAttribute("products", productServiceImp.findAll());
        return "assetAdmin/purchaseAdd";
    }

    @GetMapping("/purchase/findOne")
    public String findPurchase(Integer bid, Model model){
        model.addAttribute("purchase", buyServiceImp.findById(bid));
        return "assetAdmin/purchaseDetail";
    }

    @GetMapping("/assignment/findOne")
    public String findAssignment(Integer id, Model model){
        model.addAttribute("assignment", assignmentServiceImp.findById(id));
        return "assetAdmin/assignmentDetail";
    }

    @GetMapping("/repair/findOne")
    public String findRepair(Integer id, Model model){
        model.addAttribute("repair", repairServiceImp.findById(id));
        return "assetAdmin/repairDetail";
    }

}
