package com.oil.web.job;

import cn.hutool.core.util.StrUtil;
import com.oil.web.manager.CosManager;
import com.oil.web.mapper.GeneratorMapper;
import com.oil.web.model.entity.Generator;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 清除无用文件定时任务
 *
 * @author 走肖
 * @version 2.3
 */
@Component
@Slf4j
public class ClearCosJobHandler {

    @Resource
    private CosManager cosManager;

    @Resource
    private GeneratorMapper generatorMapper;

    /**
     * 每天执行清除任务
     */
    @XxlJob("clearCosJobHandler")
    public void clearCosJobHandler() {
        log.info("clearCosJobHandler start");
        // 编写业务逻辑
        // 1. 包括用户上传的模板制作文件（generator_make_template）
        cosManager.deleteDir("/generator_make_template/");

        // 2. 已删除的代码生成器对应的产物包文件（generator_dist）
        List<Generator> generatorList = generatorMapper.listDeletedGenerator();
        List<String> keyList = generatorList.stream().map(Generator::getDistPath)
                .filter(StrUtil::isNotBlank)
                // 移除 '/' 前缀
                .map(distPath -> distPath.substring(1))
                .collect(Collectors.toList());

        cosManager.deleteObjects(keyList);
        log.info("clearCosJobHandler end");
    }
}
