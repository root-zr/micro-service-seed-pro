package com.seed.pro.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seed.pro.user.entity.Blog;
import com.seed.pro.user.mapper.BlogMapper;
import com.seed.pro.user.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhirong
 * @since 2021-04-29
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
