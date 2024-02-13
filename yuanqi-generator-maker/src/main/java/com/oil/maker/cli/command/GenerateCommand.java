package com.oil.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.oil.maker.generator.file.FileGenerator;
import com.oil.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author 走肖
 * @version 2.3
 * 代码生成命令
 */
@Data  // 此处加该注解的原因，类种属性是私有的，使用 BeanUtil 拷贝不过去，需要添加通过 @Data get/set 方法
@Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l", "--loop"}, description = "是否循环", arity = "0..1", interactive = true, echo = true)
    private boolean loop;

    @Option(names = {"-a", "--author"}, description = "作者注释", arity = "0..1", interactive = true, echo = true)
    private String author = "xiao";

    @Option(names = {"-o", "--outputText"}, description = "输出信息", arity = "0..1", interactive = true, echo = true)
    private String outputText = "sum = ";

    @Override
    public Integer call() throws Exception {
        // 将命令行输入传递给动态模板
        DataModel mainTemplateConfig = new DataModel();
//        mainTemplateConfig.setLoop(loop);
//        mainTemplateConfig.setAuthor(author);
//        mainTemplateConfig.setOutputText(outputText);
        // 因为该类的属性和动态模板属性一模一样，所以我们直接使用 BeanUtil 拷贝即可
        BeanUtil.copyProperties(this, mainTemplateConfig);

        //执行动静文件生成
        FileGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }

}
