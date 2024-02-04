package com.oil.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * @author 肖周坤
 * @version 2.3
 * Picocli 命令行工具示例代码（命令解析）
 */
// 使用 @Command 注解标记该类并为其命名，mixinStandardHelpOptions 属性设置为 true 可以给应用程序自动添加 --help 和 --version 选项
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    // 通过 @Option 注解将字段设置为命令行选项，可以给选项设置名称和描述
    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    // 通过 @Parameters 注解将字段设置为命令行参数，可以指定默认值、描述等信息
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args); // args 通过命令行传入 -s 22 走肖
        System.exit(exitCode);
    }
}