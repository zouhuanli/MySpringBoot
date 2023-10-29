package com.homura.myspringboot.entity.base;

import com.homura.myspringboot.config.EnumResponseStatus;
import com.homura.myspringboot.utils.LocalDateUtils;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class ResponseResult<T extends Serializable> {
    /**
     * 时间戳：yyyyMMddHHmmssSSS
     */
    private String timestamp;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;

    /**
     * 相应数据
     */
    private T respData;

    public static <T extends Serializable> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().respData(data)
                .msg(EnumResponseStatus.SUCCESS.getDescription())
                .code(EnumResponseStatus.SUCCESS.getResponseCode())
                .timestamp(LocalDateUtils.getCurrentTimestamp())
                .build();
    }

    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().respData(data)
                .msg(message)
                .code(EnumResponseStatus.FAIL.getResponseCode())
                .timestamp(LocalDateUtils.getCurrentTimestamp())
                .build();
    }
}
