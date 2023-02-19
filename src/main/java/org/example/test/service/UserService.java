package org.example.test.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.test.dto.UserPageRequestDTO;
import org.example.test.entity.UserEntity;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:22
 */
public interface UserService extends IService<UserEntity> {

    Page<UserEntity> page(UserPageRequestDTO param);

}
