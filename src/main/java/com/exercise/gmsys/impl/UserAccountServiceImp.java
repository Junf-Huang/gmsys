package com.exercise.gmsys.impl;

import com.exercise.gmsys.mapper.UserAccountMapper;
import com.exercise.gmsys.model.UserAccount;
import com.exercise.gmsys.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAccountServiceImp implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;


    @Override
    public UserAccount findUserByAccount(String account) {
        return userAccountMapper.findByAccount(account);
    }

    @Override
    public UserAccount selectByPrimaryKey(Integer USERID) {
        return userAccountMapper.selectByPrimaryKey(USERID);
    }

}
