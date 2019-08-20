package com.lh.utils;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class TableResultResponse {
    /**
     * 状态,默认值是0,比如成功是200,错误500等
     */
    private int code = 0;
    /**
     * 信息
     */
    private String msg = "";
    /**
     * 总数
     */
    private long count = 0;
    /**
     * 数据
     */
    private List<Map<String, Object>> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}