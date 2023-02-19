package org.example.test.exception;

/**
 * 客户端异常，比如请求参数未通过校验
 * @Author yuzh
 * @Date 2023/2/19 17:29
 */
public class ParamException extends RuntimeException {

    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
