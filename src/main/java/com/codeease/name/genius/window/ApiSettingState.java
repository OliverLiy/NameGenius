package com.codeease.name.genius.window;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ApiSettingState
 * @Description: Api配置的持久化类
 * @Date: 2024/7/20 下午11:53
 */
@State(
        name = "com.codeease.name.genius.window.ApiSettingState",
        storages = @Storage("ApiSettingState.xml")
)
public class ApiSettingState implements PersistentStateComponent<ApiSettingState> {

    public String api = "";

    public static ApiSettingState getInstance(){
        return ServiceManager.getService(ApiSettingState.class);
    }

    @Nullable
    @Override
    public ApiSettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ApiSettingState apiSettingState) {
        this.api = apiSettingState.api;
    }
}
