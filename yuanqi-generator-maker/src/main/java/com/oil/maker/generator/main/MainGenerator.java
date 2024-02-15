package com.oil.maker.generator.main;

/**
 * @author 走肖
 * @version 2.3
 * 覆写实现不同行为
 */
public class MainGenerator extends GenerateTemplate {

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("例如：不生成产物包...");
    }

}
