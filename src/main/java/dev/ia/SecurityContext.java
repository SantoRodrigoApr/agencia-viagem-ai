package dev.ia;

public final class SecurityContext {

    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();

    private SecurityContext() {
        // Prevent instantiation
    }

    public static void setCurrentUser(String username) {
        CURRENT_USER.set(username);
    }

    public static String getCurrentUser() {
        return CURRENT_USER.get();
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}