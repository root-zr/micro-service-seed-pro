package com.seed.pro.user.controller;

import cn.hutool.core.map.MapUtil;
import com.seed.pro.common.lang.Result;
import com.seed.pro.user.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhirong
 * @since 2021-04-29
 */
@RefreshScope
@RestController
public class TestApplicationYmlController {

    @Value("${test-config.user}")
    private String userName;

    @Value("${test-config.password}")
    private String password;

    @GetMapping("/getUser")
    public Result getUser() {

        return Result.succ(MapUtil.builder()
                .put("userName", userName)
                .put("password",password)
                .build());
    }



}


