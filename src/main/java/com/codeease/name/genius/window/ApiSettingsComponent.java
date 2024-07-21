package com.codeease.name.genius.window;

import javax.swing.*;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ApiSettingsComponent
 * @Description: 设置组件类
 * @Date: 2024/7/20 下午11:56
 */
public class ApiSettingsComponent {
    private JPanel panel;
    private JTextField apiTestField;

    public ApiSettingsComponent() {
        panel = new JPanel();
        apiTestField = new JTextField(40);
        panel.add(new JLabel("请输入Ollama的Api:"));
        panel.add(apiTestField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getApi() {
        return apiTestField.getText();
    }

    public void setApi(String api) {
        apiTestField.setText(api);
    }
}
