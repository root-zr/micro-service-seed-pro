package com.seed.pro.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seed.pro.user.entity.User;
import com.seed.pro.user.mapper.UserMapper;
import com.seed.pro.user.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
