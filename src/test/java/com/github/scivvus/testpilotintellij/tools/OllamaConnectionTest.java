package com.github.scivvus.testpilotintellij.tools;

import org.junit.Before;
import org.junit.Test;

import java.net.ConnectException;
import java.util.concurrent.CompletionException;

import static com.github.scivvus.testpilotintellij.tools.OllamaConnection.TEST_PILOT_TEST_MODEL;
import static org.junit.Assert.*;

public class OllamaConnectionTest {

    private OllamaConnection ollamaConnection;

    @Before
    public void setUp() {
        ollamaConnection = new OllamaConnection(TEST_PILOT_TEST_MODEL);
    }

    @Test
    public void testAskQuestion() throws CompletionException {
        String dummyFile = """
                import java.io.*;
                import java.util.Scanner;

                class MyClass {
                    // very simple inefficient brute force string reversal
                    public String reverse (String arg) {
                        String rev = "";
                        for (int i = 0; i < arg.length(); i++) {
                            rev = arg.charAt(i) + rev;
                        }

                        return rev;
                    }
                }
                """;
        try {
            String answer = ollamaConnection.createUnitTestForMethod(dummyFile, 10);
            assertNotNull(answer);
            System.out.println(answer);
        } catch (ConnectException e) {
            System.out.println("Ollama is not running");
        }
    }
}