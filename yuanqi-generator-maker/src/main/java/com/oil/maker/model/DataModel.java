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
     * 是否生成 .gitignore 文件
     */
    public boolean needGit;

    /**
     * 是否生成循环（开关）
     */
    public boolean loop;


    /**
     * 核心模板
     */
    public MainTemplate mainTemplate = new MainTemplate();

    /**
     * 用于生成核心模板文件
     */
    @Data
    public static class MainTemplate {

        /**
         * 作者注释（填充词）
         */
        public String author = "xiao";

        /**
         * 输出信息
         */
        public String outputText = "sum = ";
    }
}
