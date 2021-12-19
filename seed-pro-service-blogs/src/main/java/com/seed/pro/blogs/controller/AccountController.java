package com.seed.pro.blogs.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seed.pro.blogs.entity.User;
import com.seed.pro.blogs.service.UserService;
import com.seed.pro.common.dto.LoginDto;
import com.seed.pro.common.dto.RegisterDto;
import com.seed.pro.common.lang.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class AccountController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result register(@Validated @RequestBody RegisterDto registerDto)
    {

        User user = userService.getOne(new QueryWrapper<User>().eq("username", registerDto.getUsername()));

        if(user != null ){
            return Result.fail("用户已存在！");
        }

        User new_user = new User();
        new_user.setUsername(registerDto.getUsername());
        new_user.setPassword(SecureUtil.md5(registerDto.getPassword()));
        new_user.setEmail(registerDto.getEmail());
        new_user.setStatus(0);
        userService.saveOrUpdate(new_user);

        return Result.succ(null);

    }

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUserId()));
        Assert.notNull(user, "用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确");
        }

//        if(!user.getPassword().equals(loginDto.getPassword())){
//            return Result.fail("密码不正确");
//        }

        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    @GetMapping("/logout")
    public Result logout() {
        return Result.succ(null);
    }



}
