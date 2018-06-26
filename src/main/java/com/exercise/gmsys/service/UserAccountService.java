package com.exercise.gmsys.service;

import com.exercise.gmsys.model.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountService {

    public UserAccount findUserByAccount(String account);

    public UserAccount selectByPrimaryKey(Integer USERID);
}
