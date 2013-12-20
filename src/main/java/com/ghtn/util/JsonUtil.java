package com.ghtn.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * json工具类
 */
public class JsonUtil {

    /**
     * 把list转为json
     *
     * @param list 需要转换的list
     * @return 转换之后的json对象
     * @throws JSONException 抛出json异常信息
     */
    public static JSONObject listToJson(List<?> list) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("returnList", list);
        return json;
    }

    /**
     * 把map转换为json
     *
     * @param map 需要转换的map
     * @return 转换之后的json对象
     * @throws JSONException 抛出json异常信息
     */
    public static JSONObject mapToJson(Map<?, ?> map) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("returnMap", map);
        return json;
    }

}
