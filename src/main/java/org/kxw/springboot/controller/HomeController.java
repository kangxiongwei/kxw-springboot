package org.kxw.springboot.controller;

import org.kxw.springboot.model.BaseResponse;
import org.kxw.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2018/6/28 19:33.
 */
@RestController
public class HomeController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/login")
    public BaseResponse login(@RequestParam String username, @RequestParam String password) {
        BaseResponse response = new BaseResponse();
        boolean isLogin = this.userService.login(username, password);
        response.setCode(isLogin ? 200: 500);
        response.setMsg(isLogin ? "登录成功" : "登录失败");
        response.setData(isLogin);
        return response;
    }

}
