package com.oil.maker;

import com.oil.maker.cli.CommandExecutor;
import com.oil.maker.cli.utils.OptionUtil;
import com.oil.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author 走肖
 * @version 2.3
 * 整个代码生成器项目的全局调用入口
 */
public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        // 测试，打包时注释掉
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
//        CommandExecutor commandExecutor = new CommandExecutor();
        // todo 接收 args 时检验是否含有对应参数(结合之前的 OptionUtil 工具类)
//        commandExecutor.doExecute(args);

        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }

}
