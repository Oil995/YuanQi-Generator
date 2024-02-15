package com.oil.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author 走肖
 * @version 2.3
 */
public class MetaManager {

    private static volatile Meta meta;

    public static Meta getMetaObject() {
        // 判断对象是否实例化过，没有实例化过才进入加锁代码
        if (meta == null) {
            // 类对象加锁
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // 校验配置文件，处理默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;
    }

}
