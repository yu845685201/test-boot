package org.example.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.test.constant.Result;
import org.example.test.dto.UserPageRequestDTO;
import org.example.test.entity.UserEntity;
import org.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yuzh
 * @Date 2023/2/19 19:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增
     * @param param
     * @return
     */
    @PostMapping
    public Result create(@RequestBody UserEntity param) {
        userService.save(param);
        return Result.succ();
    }

    /**
     * 修改
     * @param param
     * @return
     */
    @PutMapping
    public Result modify(@RequestBody UserEntity param) {
        userService.updateById(param);
        return Result.succ();
    }

    /**
     * 分页列表
     * @param param
     * @return
     */
    @GetMapping
    public Result<Page<UserEntity>> page(@RequestBody UserPageRequestDTO param) {
        return Result.succ(userService.page(param));
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<UserEntity> get(@PathVariable("id") Long id) {
        return Result.succ(userService.getById(id));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return Result.succ(userService.removeById(id));
    }
}
