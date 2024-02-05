package com.oil.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.oil.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author 走肖
 * @version 2.3
 * 参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

//        // 获取要打印属性信息的类
//        Class<?> myClass = MainTemplateConfig.class;
//        // 获取类的所有字段
//        Field[] fields = myClass.getDeclaredFields();  // 使用原生反射 api 实现

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class); // 使用 hutool 实现

        // 遍历并打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
