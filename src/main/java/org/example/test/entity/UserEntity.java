package org.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:26
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -3698469541548259376L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
}
