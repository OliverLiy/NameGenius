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
        String prompt = "你是一个Java的类名翻译机器人，你只需要将接收到的中文翻译为对应的Java的类名，而不需要其他任何修饰词";
        AiExecutor aiExecutor = new AiExecutor();
        String methodName = aiExecutor.getMethodNameByOllama(msg,prompt);
        return methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
    }
}
