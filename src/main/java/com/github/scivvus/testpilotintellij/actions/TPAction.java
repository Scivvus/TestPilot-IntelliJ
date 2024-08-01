package com.github.scivvus.testpilotintellij.actions;

import com.github.scivvus.testpilotintellij.services.TPService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class TPAction extends AnAction {
    private static final Logger LOGGER = Logger.getInstance(TPAction.class);

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        VirtualFile virtualFile = anActionEvent.getData(CommonDataKeys.VIRTUAL_FILE);
        if (virtualFile != null && "java".equals(virtualFile.getExtension())) {
            // get the file contents
            FileDocumentManager fileDocumentManager = FileDocumentManager.getInstance();
            String javaFileContents = fileDocumentManager.getDocument(virtualFile).getText();

            // get what line the cursor, aka primary caret, is on
            Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
            LogicalPosition logicalPosition = editor.getCaretModel().getPrimaryCaret().getLogicalPosition();
            int selectedLinenumber = logicalPosition.line;

            TPService tpService = anActionEvent.getProject().getService(TPService.class);
            try {
                tpService.createUnitTestForMethod(javaFileContents, selectedLinenumber);
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
    }
}
