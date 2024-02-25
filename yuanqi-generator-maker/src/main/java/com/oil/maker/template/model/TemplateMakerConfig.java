package com.oil.maker.template.model;

import com.oil.maker.meta.Meta;
import lombok.Data;

/**
 * @author 走肖
 * @version 2.3
 * 模板制作配置
 */
@Data
public class TemplateMakerConfig {

    private Long id;

    private Meta meta = new Meta();

    private String originProjectPath;

    TemplateMakerFileConfig fileConfig = new TemplateMakerFileConfig();

    TemplateMakerModelConfig modelConfig = new TemplateMakerModelConfig();
}
