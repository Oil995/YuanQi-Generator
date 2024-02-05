package com.oil.cli.utils;

import picocli.CommandLine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 走肖
 * @version 2.3
 * Option 注解工具类
 */
public class OptionUtil {

    /**
     * 强制交互（针对用户不自行添加输入选项也能交互输入）
     *
     * @param clazz @Option 注解字段类
     * @param args  传入指令
     * @return
     */
    public static String[] isInteractiveInOption(Class<?> clazz, String[] args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        // 遍历反射获取类的所有字段
        for (Field field : clazz.getDeclaredFields()) {
            // 获取字段上的Option注解，并检查其interactive属性
            CommandLine.Option option = field.getAnnotation(CommandLine.Option.class);
            if (option != null && option.interactive()) {
                // 获取注解中定义的名称数组的第一个元素，例如：names = {"-p", "--password"} 中的 -p
                String optionName = option.names()[0];
                // 如果传入的参数列表中不包含该属性名，则添加它
                if (!argList.contains(optionName)) {
                    argList.add(optionName);
                }
            }
        }
        // 转回数组并返回
        return argList.toArray(new String[0]);
    }
}
