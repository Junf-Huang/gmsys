package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.BuyMapper;
import com.exercise.gmsys.mapper.ProviderMapper;
import com.exercise.gmsys.model.Buy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuyServiceImp {

    @Autowired
    BuyMapper buyMapper;

    @Autowired
    ProductServiceImp productServiceImp;

    public List<Buy> findAll(){

        List<Buy> buys = buyMapper.findAll();
        for (Buy buy : buys) {
            buy.setProductID(productServiceImp.findByProviderId(buy.getPROVID()).getPRODID());
            log.info("productId={}", buy.getProductID());
        }
        return buys;
    }

    public Buy findById(Integer id){
        Buy buy = buyMapper.selectByPrimaryKey(id);
        buy.setProductID(productServiceImp.findByProviderId(buy.getPROVID()).getPRODID());
        return buy;
    }

    public void update(Buy buy){
        buyMapper.updateByPrimaryKey(buy);
    }

    public void insert(Buy buy){
        buyMapper.insert(buy);
    }

    public void delete(Integer id) {
        buyMapper.deleteByPrimaryKey(id);
    }

    public List<Buy> findByKeyword(String keyword) {

        return buyMapper.findByKeyword(keyword);
    }
}
