package com.github.scivvus.testpilotintellij;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

/**
 * TPBundle is a dynamic bundle for messages.
 */
@NonNls
public class TPBundle extends DynamicBundle {

    private static final String BUNDLE = "messages.MyBundle";

    public static final TPBundle INSTANCE = new TPBundle();

    public TPBundle() {
        super(BUNDLE);
    }

    /**
     * Returns the message for the given key.
     *
     * @param key   the resource bundle key
     * @param params the parameters to be used in the message
     * @return the formatted message
     */
    public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getMessage(key, params);
    }

    /**
     * Returns a lazy message for the given key.
     *
     * @param key   the resource bundle key
     * @param params the parameters to be used in the message
     * @return the formatted message
     */
    @SuppressWarnings("unused")
    public static Supplier<String> messagePointer(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getLazyMessage(key, params);
    }
}
