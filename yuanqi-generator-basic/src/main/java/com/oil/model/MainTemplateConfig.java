package com.oil.model;

import lombok.Data;

/**
 * @author 肖周坤
 * @version 2.3
 * 动态模版配置
 */
@Data
public class MainTemplateConfig {

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
