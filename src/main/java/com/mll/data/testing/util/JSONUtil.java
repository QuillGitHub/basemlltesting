package com.mll.data.testing.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONUtil {

    public static final String CODE = "code";

    public static final String TOTAL = "total";

    public static final String DATA = "data";

    public static final String MESSAGE = "msg";

    public static String assemble(Result result, String msg) {
        JSONObject object = new JSONObject();
        object.put(CODE, result.getCode());
        object.put(MESSAGE, msg);
        return JSON.toJSONString(object, FastJSONConfig.FEATURES);
    }

/**
     *
     * @param code
     * @param list
     * @param msg
     * @return
     */

    public static String assemble(int code, Collection list, String msg) {
        JSONObject object = new JSONObject();
        object.put(CODE, code);
        if (Result.SUCCESS.getCode() == code) {
            object.put(DATA, list == null ? new ArrayList() : list);
            msg = msg == null ? Result.SUCCESS.getMsg() : msg;
        } else {
            msg = msg == null ? Result.FAILURE.getMsg() : msg;
        }
        object.put(MESSAGE, msg);
        return JSON.toJSONString(object, FastJSONConfig.FEATURES);
    }

    public static String assemble(int code, Collection list) {
        return assemble(code, list, null);
    }

    public static String assemble(Result result, PageInfo<?> page, String msg) {
        int code = result.getCode();
        JSONObject object = new JSONObject();
        object.put(CODE, code);
        if (Result.SUCCESS.getCode() == code) {
            object.put(TOTAL, page.getTotal());
            object.put(DATA, page.getList());
            msg = msg == null ? Result.SUCCESS.getMsg() : msg;
        } else {
            msg = msg == null ? Result.FAILURE.getMsg() : msg;
        }
        object.put(MESSAGE, msg);
        return JSON.toJSONString(object, FastJSONConfig.FEATURES);
    }

    public static String assemble(Result result, PageInfo<?> page) {
        return assemble(result, page, null);
    }

    public static String assemble(Result result, Object obj) {
        return assemble(result, obj, null);
    }

    public static String assemble(Result result, Object obj, String msg) {
        int code = result.getCode();
        JSONObject object = new JSONObject();
        object.put(CODE, code);
        if (Result.SUCCESS.getCode() == code) {
            if (obj instanceof String) {
                object.put(DATA, obj);
            } else if (obj instanceof Page) {
                Page page = (Page) obj;
                if (Result.SUCCESS.getCode() == code) {
                    object.put(TOTAL, page.getTotalElements());
                    object.put(DATA, page.getContent());
                }
            } else if (obj instanceof List) {
                object.put(DATA, (List) obj);
            } else {
                object.put(DATA, obj);
            }
            msg = msg == null ? Result.SUCCESS.getMsg() : msg;
        } else {
            msg = msg == null ? Result.FAILURE.getMsg() : msg;
        }
        object.put(MESSAGE, msg);
        return JSON.toJSONString(object, FastJSONConfig.FEATURES);
    }

}
