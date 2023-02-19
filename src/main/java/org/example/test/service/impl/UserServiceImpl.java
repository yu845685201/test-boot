package org.example.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.test.dto.UserPageRequestDTO;
import org.example.test.entity.UserEntity;
import org.example.test.mapper.UserMapper;
import org.example.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public Page<UserEntity> page(UserPageRequestDTO param) {
        Page<UserEntity> page = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.<UserEntity>lambdaQuery().orderByDesc(UserEntity::getId);
        if(StringUtils.hasText(param.getUsername())) {
           queryWrapper.like(UserEntity::getUsername, param.getUsername());
        }
        return baseMapper.selectPage(page, queryWrapper);
    }
}
