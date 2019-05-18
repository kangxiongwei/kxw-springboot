package org.kxw.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.kxw.springboot.pojo.Result;
import org.kxw.springboot.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2019/5/18 2:34 PM
 */
@Slf4j
@RestController
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

    /**
     * 购买商品接口
     */
    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId, Integer quantity) {
        log.info("请求参数：userId={}, productId={}, quantity={}", userId, productId, quantity);
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String message = success ? "抢购成功" : "抢购失败";
        return new Result(success, message);
    }


}
