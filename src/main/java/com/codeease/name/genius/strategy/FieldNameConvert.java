package com.codeease.name.genius.strategy;

import com.codeease.name.genius.executor.AiExecutor;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: FieldNameConvert
 * @Description: 属性名转换
 * @Date: 2024/7/21 下午5:54
 */
public class FieldNameConvert implements NameConvertStrategy{

    @Override
    public String execute(String msg) {
        String prompt = "你是一个Java的变量名翻译机器人，你只需要将接收到的中文翻译为对应的Java的变量名，而不需要其他任何修饰词";
        AiExecutor aiExecutor = new AiExecutor();
        return aiExecutor.getMethodNameByOllama(msg,prompt);
    }
}
