package com.github.scivvus.testpilotintellij.services;

import com.github.scivvus.testpilotintellij.tools.OllamaConnection;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.net.ConnectException;
import java.util.concurrent.CompletionException;

@Service(Service.Level.PROJECT)
public final class TPService {
    private static final Logger LOGGER = Logger.getInstance(TPService.class);

    private final OllamaConnection ollamaConnection;
    private String generatedTestCode;

    public TPService(@NotNull Project project) {
        ollamaConnection = new OllamaConnection();
    }

    public String createUnitTestForMethod(@NotNull String javaFileContents, int selectedLinenumber) throws ConnectException, CompletionException {
        generatedTestCode = ollamaConnection.createUnitTestForMethod(javaFileContents, selectedLinenumber);
        return generatedTestCode;
    }

    public String getGeneratedTestCode() {
        return generatedTestCode;
    }
}
