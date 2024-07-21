package com.codeease.name.genius.strategy;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: NameConvertStrategy
 * @Description: 名字转换策略类
 * @Date: 2024/7/18 下午3:59
 */
public interface NameConvertStrategy {

    /**
     * 名称转换
     * @param msg
     * @return
     */
    String execute(String msg);
}
