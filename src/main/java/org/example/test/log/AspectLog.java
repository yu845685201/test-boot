package org.example.test.log;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 日志切面，用于记录每次请求的日志，方便排查问题
 * @Author yuzh
 * @Date 2023/2/20 21:57
 */
@Aspect
@AllArgsConstructor
@Slf4j
@Component
public class AspectLog {
    @Pointcut("execution (* org.example..*Controller.*(..))")
    private void pointcut() {
    }

    @SneakyThrows
    @Around("pointcut()")
    public Object saveSysLog(ProceedingJoinPoint point) {
        // 请求的参数
        Object[] args = point.getArgs();
        List<Object> argList = Arrays.stream(args).filter(e -> !(e instanceof HttpServletRequest || e instanceof HttpServletResponse || e instanceof HttpSession || e instanceof MultipartFile)).collect(Collectors.toList());
        String params = JSON.toJSONString(argList);
        Long startTime = System.currentTimeMillis();
        String funcStr = point.getSignature().toLongString();
        log.info("切面请求方法:{}, 参数:{}", funcStr, params);
        Object obj = point.proceed();
        Long endTime = System.currentTimeMillis();
        String result = JSON.toJSONString(obj);

        //超长日志截取10000字符
        if (result != null && result.length() > 10100) {
            result = result.substring(0, 10000) + "...";
        }
        log.info("切面返回方法:{}, 请求耗时:{}, 返回:{}", funcStr, endTime - startTime, result);
        return obj;
    }
}
