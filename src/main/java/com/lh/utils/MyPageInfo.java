package com.lh.utils;

import lombok.Data;

/**
 * <p>Description: 自定义的分页信息类</p>
 *
 * @Author yao
 */
@Data
public class MyPageInfo {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer perPage;
}
