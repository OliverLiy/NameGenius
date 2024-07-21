package com.codeease.name.genius.action;

import com.codeease.name.genius.enmus.NameTypeEnum;
import com.codeease.name.genius.executor.NamePopupExecutor;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: GenerateNameAction
 * @Description:
 * @Date: 2024/7/18 下午3:45
 */
public class GenerateNameAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = (Editor) event.getDataContext().getData("editor");
        Project project = event.getProject();

        // 创建要展示的列表数据
        List<String> typeNameList = NameTypeEnum.getTypeNameList();
        // 创建列表弹出窗口
        ListPopup listPopup = JBPopupFactory.getInstance()
                .createListPopup(new NamePopupExecutor("Name Type",typeNameList,editor,project));
        // 在屏幕中间显示列表弹出窗口
        listPopup.showCenteredInCurrentWindow(Objects.requireNonNull(event.getProject()));
    }
}
