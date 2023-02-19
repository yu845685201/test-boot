package org.example.test.config;

import lombok.extern.slf4j.Slf4j;
import org.example.test.constant.Result;
import org.example.test.exception.ParamException;
import org.example.test.exception.ServerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 * 定义了统一异常处理，Controller中就不需要做异常处理了，有异常直接抛出，统一异常处理类中会捕获相应的异常，并且进行处理
 * @Author yuzh
 * @Date 2023/2/19 16:19
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理Exception异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error("服务异常, {}", e.getMessage(), e);
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            // 处理404异常
            return Result.apiNotFound(req.getRequestURL().toString());
        } else {
            // 处理其他异常
            return Result.serverFail(e.getMessage());
        }
    }

    /**
     * 捕获org.example.test.exception.ParamException，处理客户端异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public Result paramExceptionHandler(Exception e) {
        log.error("客户端异常, {}", e.getMessage(), e);
        return Result.paramFail(e.getMessage());
    }

    /**
     * 捕获org.example.test.exception.ServerException，处理服务端异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServerException.class)
    @ResponseBody
    public Result serverExceptionHandler(Exception e) {
        log.error("服务端异常, {}", e.getMessage(), e);
        return Result.paramFail(e.getMessage());
    }

}
