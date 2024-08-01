package com.github.scivvus.testpilotintellij.toolWindow;

import com.github.scivvus.testpilotintellij.TPBundle;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.github.scivvus.testpilotintellij.services.TPService;
import org.jetbrains.annotations.NotNull;

import javax.swing.JButton;

public class TPWindowFactory implements ToolWindowFactory {

    private static final Logger LOGGER = Logger.getInstance(TPWindowFactory.class);

    public TPWindowFactory() {
        LOGGER.warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        MyToolWindow myToolWindow = new MyToolWindow(toolWindow);
        Content content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false);
        toolWindow.getContentManager().addContent(content);
    }

    @SuppressWarnings("RedundantMethodOverride")
    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return true;
    }

    private static class MyToolWindow {

        private final TPService service;

        public MyToolWindow(ToolWindow toolWindow) {
            this.service = toolWindow.getProject().getService(TPService.class);
        }

        public JBPanel<JBPanel<?>> getContent() {
            JBPanel<JBPanel<?>> panel = new JBPanel<>();
            JBTextArea textArea = new JBTextArea();
            panel.add(textArea);

            JButton button = new JButton(TPBundle.message("getCode"));
            button.addActionListener(e -> textArea.setText(service.getGeneratedTestCode()));
            panel.add(button);

            return panel;
        }
    }
}