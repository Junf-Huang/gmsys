package com.exercise.gmsys.controller;

import com.exercise.gmsys.impl.UserAccountServiceImp;
import com.exercise.gmsys.model.UserAccount;
import com.exercise.gmsys.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserAccountController {

    // 在mvc的控制层整合service服务层

    @Autowired
    private UserAccountService userAccountService;

    //在浏览中通过URL调用这个方法进行登录:doLogin.do
    @PostMapping("/doLogin")
    public String doLogin(String account, String password, HttpSession session, Model model) {

        //UserAccount userAccount = userAccountService.findUserByAccount(account);
        UserAccount userAccount = userAccountService.selectByPrimaryKey(3);

        log.info("loginName={}", userAccount.getACCOUNTS());
        log.info("password={}", userAccount.getPASSWORD());
        if (userAccount != null && userAccount.getPASSWORD().equals(password)) {
            // 登录成功，进入到管理界面
            //保存用户登录状态
            session.setAttribute("login", true);
            session.setAttribute("loginUser", userAccount);

            return "index";
        } else {
            // 登录失败，返回登录页面
            //删除登录状态，避免登录后再次登录
            session.removeAttribute("login");
            return "login";
        }
    }//end


    @GetMapping("/doLogout")
    public String doLogout(HttpSession session) {

        /**
         *
         * 1.HttpSession session是jsp/servlet技术中的会话对象，它用于一个浏览器窗口多次访问服务器时，可以在多个页面或servlet间共享数据
         * 2.只要当前浏览器窗口没有关闭，或会话没有超时(默认30分钟超时),就可以使用session在服务端共享数据
         * 3.特别的，浏览器一旦关闭，再次打开时会开启一个新的会话。之前保存在会话中的数据就无法在使用
         *
         *
         * 4.会话的时间是比较长的。对应在一次请求中共享的数据，应该使用HttpServletRequest对象进行保存共享
         *
         *
         */

        //退出，要清除用户登录状态以及登录用的信息
        session.removeAttribute("login");
        session.removeAttribute("loginUser");
        return "login";
    }

    @ResponseBody
    @GetMapping(value = "/test")
    public UserAccount test(){
        log.info("user={}",userAccountService.findUserByAccount("admin"));
        return userAccountService.findUserByAccount("admin");
    }
}

