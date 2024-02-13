package com.oil.maker.cli;

import com.oil.maker.cli.command.ConfigCommand;
import com.oil.maker.cli.command.GenerateCommand;
import com.oil.maker.cli.command.ListCommand;
import com.oil.maker.cli.utils.OptionUtil;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author 走肖
 * @version 2.3
 * 命令执行器
 */
@Command(name = "yuanqi", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private static CommandLine commandLine;

    { // 无论执行多少次命令，都是使用该 commandLine 对象，使用代码块（类是静态用静态代码块）
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     *
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
//        return new CommandLine(new GenerateCommand()).execute(OptionUtil.isInteractiveInOption(GenerateCommand.class, args));
        return commandLine.execute(args);
    }
}
