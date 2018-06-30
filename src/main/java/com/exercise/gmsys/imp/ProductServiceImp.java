package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.ProductMapper;
import com.exercise.gmsys.mapper.ProductMapper;
import com.exercise.gmsys.model.Department;
import com.exercise.gmsys.model.Product;
import com.exercise.gmsys.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp {

    @Autowired
    ProductMapper productMapper;

    public List<Product> findAll(){

        return productMapper.findAll();
    }

    public Product findById(Integer id){
        return productMapper.selectByPrimaryKey(id);
    }

    public void update(Product product){
        productMapper.updateByPrimaryKey(product);
    }

    public void insert(Product product){
        productMapper.insert(product);
    }

    public void delete(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }

    public List<Product> findByKeyword(String keyword) {

        return productMapper.findByKeyword(keyword);
    }

    Product findByProviderId(Integer id) {
        return productMapper.findByProviderId(id);
    }

}
