package com.exercise.gmsys.imp;

import com.exercise.gmsys.mapper.AssignmentMapper;
import com.exercise.gmsys.model.Assignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AssignmentServiceImp {

    @Autowired
    AssignmentMapper assignmentMapper;

    public List<Assignment> findAll(){

        return assignmentMapper.findAll();
    }

    public Assignment findById(Integer cid){
        return assignmentMapper.selectByPrimaryKey(cid);
    }

    public void update(Assignment assignment){
        assignmentMapper.updateByPrimaryKey(assignment);
    }

    public void insert(Assignment assignment){
        assignmentMapper.insert(assignment);
    }

    public void delete(Integer ID) {
        assignmentMapper.deleteByPrimaryKey(ID);
    }

    public List<Assignment> findByKeyword(String keyword) {

        return assignmentMapper.findByKeyword(keyword);
    }
}
