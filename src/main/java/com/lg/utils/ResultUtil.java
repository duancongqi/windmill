package com.lg.utils;

import lombok.Data;

/**
 * @类名称: ResultUtil
 * @作者: 段聪祺
 * @创建时间: 2018/11/13 10:50
 * @说明: 返回工具类
 */
@Data
public class ResultUtil {
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回状态信息
     */
    private String msg;
    /**
     * 返回值集合
     */
    private Object date;
}
