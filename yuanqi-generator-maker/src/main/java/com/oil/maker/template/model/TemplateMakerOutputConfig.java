package com.oil.maker.template.model;

import lombok.Data;

/**
 * @author 走肖
 * @version 2.3
 * 输出配置
 */
@Data
public class TemplateMakerOutputConfig {

    // 从未分组文件中移除组内的同名文件
    private boolean removeGroupFilesFromRoot = true;
}