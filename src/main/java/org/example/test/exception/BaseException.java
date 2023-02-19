package org.example.test.exception;

/**
 * @Author yuzh
 * @Date 2023/2/19 17:29
 */
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
