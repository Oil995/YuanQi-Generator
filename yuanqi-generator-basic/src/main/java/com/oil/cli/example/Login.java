package com.oil.cli.example;

import com.oil.cli.utils.OptionUtil;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author 肖周坤
 * @version 2.3
 * Picocli 命令行工具示例代码（交互式输入）
 */
public class Login implements Callable<Integer> { // 实现 Callable 接口，对结果进行返回

    @Option(names = {"-u", "--user"}, description = "User name") // echo 参数可以设置是否显示用户输入内容
    String user;

    // 将 @Option 注解的 interactive 参数设置为 true，表示该选项支持交互式输入
    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true, prompt = "请输入密码") // prompt 参数设置提示语
            String password;

    // arity = "0..1" 表示用户是否自行输入 -cp 参数，都支持交互式输入
    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true, prompt = "请确认密码")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {

        new CommandLine(new Login()).execute(OptionUtil.isInteractiveInOption(Login.class, args)); // args 通过命令行传入 -u xiao -p
    }
}