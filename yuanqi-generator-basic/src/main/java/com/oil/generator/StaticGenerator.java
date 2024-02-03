package com.oil.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author 肖周坤
 * @version 2.3
 * 静态文件生成
 */
public class StaticGenerator {

    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径：ACM 示例代码模板目录
        String inputPath = new File(parentFile, "yuanqi-generator-demo" + File.separator +
                "acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
//        copyFilesByHutool(inputPath, outputPath);
        copyFilesByRecursive(inputPath, outputPath);
    }

    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 递归拷贝文件
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            ensureOutputDirectoryExists(outputFile);
            copyFileOrDirectory(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("文件复制过程中发生错误: ");
            e.printStackTrace();
        }
    }

    /**
     * 确保目标目录存在
     *
     * @param outputFile 输出文件
     * @throws IOException
     */
    private static void ensureOutputDirectoryExists(File outputFile) throws IOException {
        if (!outputFile.exists() && !outputFile.mkdirs()) {
            throw new IOException("无法创建目标目录: " + outputFile.getAbsolutePath());
        }
    }

    /**
     * 拷贝文件或目录
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFileOrDirectory(File inputFile, File outputFile) throws IOException {
        if (inputFile.isDirectory()) {
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目标目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件，直接返回
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下层文件
                copyFileOrDirectory(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制到目标目录下
            Path sourcePath = inputFile.toPath();
            Path destinationPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
