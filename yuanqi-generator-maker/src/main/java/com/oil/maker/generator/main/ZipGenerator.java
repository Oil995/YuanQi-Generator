package com.oil.maker.generator.main;

/**
 * @author 走肖
 * @version 2.3
 * 代码生成器压缩包
 */
public class ZipGenerator extends GenerateTemplate {

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        String buildDist = super.buildDist(outputPath, sourceCopyDestPath, jarPath, shellOutputFilePath);
        return super.buildZip(buildDist);
    }

}
