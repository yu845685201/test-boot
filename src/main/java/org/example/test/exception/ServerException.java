package org.example.test.exception;

/**
 * 服务端异常，代码执行过程中出现的异常，如sql执行异常、空指针异常等
 * @Author yuzh
 * @Date 2023/2/19 17:29
 */
public class ServerException extends RuntimeException {

    public ServerException() {
        super();
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
