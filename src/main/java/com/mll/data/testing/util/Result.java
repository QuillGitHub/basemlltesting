package com.mll.data.testing.util;

public enum Result {

    SUCCESS(0, "成功"), FAILURE(-1, "失败");

    private Integer code;

    private String msg;

    Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
