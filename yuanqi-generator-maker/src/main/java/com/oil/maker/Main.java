package com.oil.maker;

import com.oil.maker.generator.main.GenerateTemplate;
import com.oil.maker.generator.main.MainGenerator;
import com.oil.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author 走肖
 * @version 2.3
 * 整个代码生成器项目的全局调用入口
 */
public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        GenerateTemplate generateTemplate = new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}
