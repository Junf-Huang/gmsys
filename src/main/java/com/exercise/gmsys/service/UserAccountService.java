package com.exercise.gmsys.service;

import com.exercise.gmsys.model.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

    public UserAccount findUserByAccount(String account);

    public UserAccount selectByPrimaryKey(Integer USERID);
}
