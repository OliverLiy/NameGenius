package com.codeease.name.genius.strategy;

import com.codeease.name.genius.executor.AiExecutor;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ClassNameConvert
 * @Description:
 * @Date: 2024/7/18 下午4:01
 */
public class ClassNameConvert implements NameConvertStrategy{
    @Override
    public String execute(String msg) {
        AiExecutor aiExecutor = new AiExecutor();
        String methodName = aiExecutor.getMethodNameByOllama(msg);
        return methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
    }
}
