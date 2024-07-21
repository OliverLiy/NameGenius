package com.codeease.name.genius.executor;

import com.codeease.name.genius.enmus.NameTypeEnum;
import com.codeease.name.genius.process.ReplaceProcess;
import com.codeease.name.genius.strategy.NameConvertStrategy;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.PopupStep;
import com.intellij.openapi.ui.popup.util.BaseListPopupStep;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: NamePopupExecutor
 * @Description:
 * @Date: 2024/7/18 下午4:15
 */
public class NamePopupExecutor extends BaseListPopupStep<String> {
    private Editor editor;
    private Project project;

    public NamePopupExecutor(@NotNull String title, @NotNull List<String> values, Editor editor, Project project) {
        super(title, values);
        this.editor = editor;
        this.project = project;
    }

    @Nullable
    @Override
    public PopupStep onChosen(String selectedValue, boolean finalChoice) {
        // 处理选中的值
        if (StringUtils.isNotBlank(selectedValue)) {
            String selectedText = editor.getSelectionModel().getSelectedText();
            if (StringUtils.isNotBlank(selectedText)){
                NameConvertStrategy strategyInstance = NameTypeEnum.getStrategyInstance(selectedValue);
                ReplaceProcess.replaceText(strategyInstance.execute(selectedText), editor, project);
            }
        }
        // 如果是最终选择，则关闭弹出窗口
        return finalChoice ? PopupStep.FINAL_CHOICE : super.onChosen(selectedValue, finalChoice);
    }

    @Override
    public boolean hasSubstep(@Nullable String selectedValue) {
        // 在这里可以定义是否有子步骤
        return false;
    }

    @Nullable
    @Override
    public String getTextFor(String value) {
        // 返回列表项的显示文本
        return value;
    }

    @Nullable
    @Override
    public Icon getIconFor(String value) {
        // 返回列表项的图标，如果不需要图标，则返回 null
        return null;
    }

}
