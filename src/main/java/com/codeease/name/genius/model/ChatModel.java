package com.codeease.name.genius.model;

import lombok.Data;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ChatModel
 * @Description: 聊天的模型对象
 * @Date: 2024/7/20 下午11:49
 */
@Data
public class ChatModel {
    private String model;
    private String prompt;
    private Boolean stream;
}
