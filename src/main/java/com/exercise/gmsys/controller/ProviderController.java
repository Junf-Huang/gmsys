package com.exercise.gmsys.controller;

import com.exercise.gmsys.imp.ProductServiceImp;
import com.exercise.gmsys.imp.ProviderServiceImp;
import com.exercise.gmsys.model.Buy;
import com.exercise.gmsys.model.Category;
import com.exercise.gmsys.model.Product;
import com.exercise.gmsys.model.Provider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ProviderController {
    @Autowired
    ProviderServiceImp providerServiceImp;

    @Autowired
    ProductServiceImp productServiceImp;

    @GetMapping("/provider/list")
    public String findProvider(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Provider> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {

            pageInfo = new PageInfo<>(providerServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(providerServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "providerAdmin/providerList";
    }

    @GetMapping("/product/list")
    public String findProduct(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "2")Integer pageSize, Model model){

        PageInfo<Product> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        if(keyword.equals("")) {

            pageInfo = new PageInfo<>(productServiceImp.findAll());
        } else {
            pageInfo = new PageInfo<>(productServiceImp.findByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("data", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "providerAdmin/productList";
    }

    @GetMapping("/provider/findById")
    public String findProviderById(Integer id, Model model){
        model.addAttribute("provider", providerServiceImp.findById(id));
        return "providerAdmin/providerUpdate";
    }

    @PostMapping("/provider/update")
    public String updateCategory(Provider provider){
        providerServiceImp.update(provider);
        return "redirect:/provider/list";
    }

    @GetMapping("/provider/findOne")
    public String findProvider(Integer id, Model model){
        model.addAttribute("provider", providerServiceImp.findById(id));
        return "providerAdmin/providerDetail";
    }

    @PostMapping("/provider/add")
    public String addProvider(Provider provider){
        providerServiceImp.insert(provider);
        return "redirect:/provider/list";
    }

    @GetMapping("/provider/delete")
    public String deleteProvider(String id) {
        String[]  ids = id.split(",");

        for (String id1 : ids) {
            log.info("cid={}", id1);
            providerServiceImp.delete(Integer.valueOf(id1));
        }
        return "redirect:/provider/list";
    }
}
