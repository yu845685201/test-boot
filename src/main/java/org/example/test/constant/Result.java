package org.example.test.constant;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author yuzh
 * @Date 2023/2/19 16:03
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3983900851267020949L;

    /** 状态码，200-接口调用成功，400-参数异常，500-服务异常 */
    private int code;
    /** 异常信息 */
    private String msg;
    /** 响应信息 */
    private T data;

    public boolean isSucc() {
        return HttpStatus.OK.value() == code;
    }

    public static <T> Result<T> of(Integer code, String msg, T data) {
        return (Result<T>) Result.builder().code(code).msg(msg).data(data).build();
    }

    public static <T> Result<T> succ() {
        return succ(null);
    }

    public static <T> Result<T> succ(T data) {
        return of(HttpStatus.OK.value(), null, data);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return of(code, msg, null);
    }

    public static <T> Result<T> apiNotFound(String api) {
        return fail(HttpStatus.NOT_FOUND.value(), api + " NOT FOUND");
    }

    public static <T> Result<T> paramFail(String msg) {
        return fail(HttpStatus.BAD_REQUEST.value(), msg);
    }

    public static <T> Result<T> serverFail(String msg) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }
}
