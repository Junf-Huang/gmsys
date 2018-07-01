package com.exercise.gmsys.mapper;

import com.exercise.gmsys.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer PRODID);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer PRODID);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> findAll();

    List<Product> findByKeyword(String keyword);

    Product findByProviderId(Integer id);

}