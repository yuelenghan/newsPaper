package com.ghtn.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理异常信息
 * User: Administrator
 * Date: 13-11-28
 * Time: 上午8:58
 */
public class BaseController {

    private static Log log = LogFactory.getLog(BaseController.class);

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleException(Exception e) {
        log.error("------------发生异常！----------------");
        log.error("Caused by : " + e.getCause());
        log.error("Message : " + e.getMessage());
        log.error("Exception : ", e);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", false);
        returnMap.put("msg", "操作失败!");
        returnMap.put("caused by", e.getCause());
        return returnMap;
    }

    public Map<String, Object> operationSuccess() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "操作成功!");
        return returnMap;
    }

}
