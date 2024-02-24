package com.oil.maker.generator.file;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author 走肖
 * @version 2.3
 * 文件生成（合）
 */
public class FileGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();  // 上级目录
        System.out.println(projectPath);
        // 静态输入路径
        String inputPath = parentFile + File.separator + "yuanqi-generator-demo" + File.separator + "acm-template";
        // 静态输出路径
        String outputPath = projectPath;

        // 静态拷贝
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        // 动态输入路径
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        // 动态输出路径
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/com.oil/acm/MainTemplate.java";

        // 再动态修改
        DynamicFileGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }

}
