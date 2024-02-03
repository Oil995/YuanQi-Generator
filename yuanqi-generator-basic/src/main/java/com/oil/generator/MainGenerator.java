package com.oil.generator;

import com.oil.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author 肖周坤
 * @version 2.3
 * 静 + 动 文件生成
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();  // 上级目录
        System.out.println(projectPath);
        // 静态输入路径
        String inputPath = parentFile + File.separator + "yuanqi-generator-demo" + File.separator + "acm-template";
        // 静态输出路径
        String outputPath = projectPath;

        // 静态拷贝
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);


        // 动态输入路径
        String dynamicInputPath = projectPath + "/src/main/resources/templates/MainTemplate.java.ftl";
        // 动态输出路径
        String dynamicOutputPath = projectPath + "/acm-template/src/com/oil/acm/MainTemplate.java";

        // 数据模板
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("走肖");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");

        // 再动态修改
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }

}
