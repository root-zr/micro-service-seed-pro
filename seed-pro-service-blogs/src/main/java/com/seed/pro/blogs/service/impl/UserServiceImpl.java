package com.seed.pro.blogs.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seed.pro.blogs.entity.User;
import com.seed.pro.blogs.mapper.UserMapper;
import com.seed.pro.blogs.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
