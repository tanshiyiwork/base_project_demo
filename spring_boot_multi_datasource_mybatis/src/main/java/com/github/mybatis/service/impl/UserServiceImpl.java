package com.github.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.mybatis.entity.User;
import com.github.mybatis.mapper.UserMapper;
import com.github.mybatis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User Service
 * </p>
 *
 * @package: com.github.mybatis.service.impl
 * @description: User Service
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
