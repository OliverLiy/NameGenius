package com.codeease.name.genius.strategy;

import com.codeease.name.genius.executor.AiExecutor;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: MethodNameConvert
 * @Description: 方法名转换
 * @Date: 2024/7/18 下午4:02
 */
public class MethodNameConvert implements NameConvertStrategy{

    @Override
    public String execute(String msg) {
        AiExecutor aiExecutor = new AiExecutor();
        return aiExecutor.getMethodNameByOllama(msg);
    }
}
