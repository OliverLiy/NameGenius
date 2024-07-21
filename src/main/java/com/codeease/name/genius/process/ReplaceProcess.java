package com.codeease.name.genius.process;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: ReplaceProcess
 * @Description:
 * @Date: 2024/7/18 下午4:35
 */
public class ReplaceProcess {
    /**
     * 替换文本
     * @param execute
     * @param editor
     * @param project
     */
    public static void replaceText(String execute, Editor editor, Project project) {
        String resultText = execute;
        Runnable runnable = () -> {
            ApplicationManager.getApplication().runWriteAction(() -> {
                Document document = editor.getDocument();
                document.replaceString(editor.getSelectionModel().getSelectionStart(), editor.getSelectionModel().getSelectionEnd(), resultText);
            });
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
    }
}

