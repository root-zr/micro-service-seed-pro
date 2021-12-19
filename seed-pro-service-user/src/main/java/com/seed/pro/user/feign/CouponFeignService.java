package com.seed.pro.user.feign;

import com.seed.pro.common.lang.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("seed-pro-blogs")  //要远程调用的服务名
public interface CouponFeignService {

    @RequestMapping("/blogs") // 要调用seed-pro-blogs的方法
    public Result getBlogs();

}
