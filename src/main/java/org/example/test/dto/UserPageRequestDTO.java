package org.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:37
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageRequestDTO extends PageRequestDTO {
    private static final long serialVersionUID = -3774945587123163045L;

    /** 查询条件 - 用户名 */
    private String username;
}
