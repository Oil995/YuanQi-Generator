package com.oil;

import com.oil.cli.CommandExecutor;

/**
 * @author 走肖
 * @version 2.3
 * 整个代码生成器项目的全局调用入口
 */
public class Main {

    public static void main(String[] args) {
        // 测试，打包时注释掉
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
