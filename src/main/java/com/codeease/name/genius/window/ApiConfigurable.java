package com.codeease.name.genius.window;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ApiConfigurable
 * @Description: API配置的最终实现
 * @Date: 2024/7/20 下午11:57
 */
public class ApiConfigurable implements Configurable {
    private ApiSettingsComponent settingsComponent;

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Name Genius";
    }

    @Override
    public @Nullable
    JComponent createComponent() {
        settingsComponent = new ApiSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ApiSettingState settings = ApiSettingState.getInstance();
        return !settingsComponent.getApi().equals(settings.api);
    }

    @Override
    public void apply() {
        ApiSettingState settings = ApiSettingState.getInstance();
        settings.api = settingsComponent.getApi();
    }

    @Override
    public void reset() {
        ApiSettingState settings = ApiSettingState.getInstance();
        settingsComponent.setApi(settings.api);
    }
}
