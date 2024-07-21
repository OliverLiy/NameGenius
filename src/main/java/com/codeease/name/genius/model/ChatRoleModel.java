package com.codeease.name.genius.model;

import lombok.Data;

import java.util.List;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ChatRoleModel
 * @Description: 带有角色的入参模型
 */
@Data
public class ChatRoleModel {
    private String model;
    private List<RoleContentModel> messages;
    private Boolean stream;
}