package com.oil.web.common;

import com.oil.web.constant.CommonConstant;
import lombok.Data;

/**
 * 分页请求
 *
 * @author 走肖
 * @version 2.3
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
