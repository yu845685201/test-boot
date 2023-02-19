package org.example.test.controller;

import org.example.test.config.TestProperties;
import org.example.test.constant.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuzh
 * @Date 2023/2/19 16:03
 */
// Controller类固定注解，@RestController类中的所有接口的响应信息，都会转换成json
@RestController
// 定义接口的根url
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestProperties testProperties;

    // Post请求，定义接口的子url，接口调用时，接口实际url是根url+子url，即/test/test1
    @PostMapping("/test1")
    public Result<String> test() {
        return Result.succ("test1 succ, " + testProperties.getMessage());
    }
}
