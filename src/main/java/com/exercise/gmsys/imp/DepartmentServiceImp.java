package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.DepartmentMapper;
import com.exercise.gmsys.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    public Department findById(Integer did){
        return departmentMapper.selectByPrimaryKey(did);
    }

    public void update(Department department){
        departmentMapper.updateByPrimaryKey(department);
    }

    public void insert(Department department){
        departmentMapper.insert(department);
    }

    public void delete(Integer did) {
        departmentMapper.deleteByPrimaryKey(did);
    }

    public List<Department> findByKeyword(String keyword) {

        return departmentMapper.findByKeyword(keyword);
    }

}
