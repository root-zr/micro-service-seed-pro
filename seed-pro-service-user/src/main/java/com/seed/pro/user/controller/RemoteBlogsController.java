package com.seed.pro.user.controller;

import com.seed.pro.common.lang.Result;
import com.seed.pro.user.entity.User;
import com.seed.pro.user.feign.CouponFeignService;
import com.seed.pro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhirong
 * @since 2021-04-29
 */
@RestController
public class RemoteBlogsController {

    @Autowired
    private CouponFeignService couponFeignService;

    @GetMapping("/get-all-blogs")
    public Result getAllBlogs() {

        return couponFeignService.getBlogs();
    }



}


