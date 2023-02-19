package org.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.test.entity.UserEntity;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:31
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
