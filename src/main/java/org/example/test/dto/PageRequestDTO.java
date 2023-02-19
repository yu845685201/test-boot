package org.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:39
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO implements Serializable {
    private static final long serialVersionUID = 1750158379008172375L;

    /** 分页参数 - 当前页数 */
    private Integer current;
    /** 分页参数 - 每页多少条 */
    private Integer size;
}
