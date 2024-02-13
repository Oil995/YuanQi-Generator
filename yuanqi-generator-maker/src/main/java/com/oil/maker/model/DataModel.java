package com.oil.maker.model;

import lombok.Data;

/**
 * @author 走肖
 * @version 2.3
 * 数据模型
 */
@Data
public class DataModel {

    /**
     * 是否生成循环（开关）
     */
    private boolean loop;

    /**
     * 作者注释（填充词）
     */
    private String author = "xiao";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";
}
