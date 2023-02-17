package com.wuke.responce;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回结果集
 */
public class Responce<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 成功
     */
    public static final int SUCCESS_CODE = HttpStatus.OK.value();

    /**
     * 失败
     */
    public static final int FAIL_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public static <T> Responce<T> success() {
        return restResult(null, SUCCESS_CODE, "操作成功");
    }

    public static <T> Responce<T> success(T data) {return restResult(data, SUCCESS_CODE, "操作成功");}

    public static <T> Responce<T> success(T data, String msg) {
        return restResult(data, SUCCESS_CODE, msg);
    }

    public static <T> Responce<T> fail() {
        return restResult(null, FAIL_CODE, "操作失败");
    }

    public static <T> Responce<T> fail(String msg) {
        return restResult(null, FAIL_CODE, msg);
    }

    public static <T> Responce<T> fail(T data) {
        return restResult(data, FAIL_CODE, "操作失败");
    }

    public static <T> Responce<T> fail(T data, String msg) {
        return restResult(data, FAIL_CODE, msg);
    }

    public static <T> Responce<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    private static <T> Responce<T> restResult(T data, int code, String msg) {
        Responce<T> apiResult = new Responce<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static <T> Boolean isSuccess(Responce<T> ret) {
        return Responce.SUCCESS_CODE == ret.getCode();
    }

    public static <T> Boolean isError(Responce<T> ret) {
        return !isSuccess(ret);
    }
}
