package utils;

public class BodyIsEmpty {
    public static boolean isBodyIsNull(String s) {
        boolean a = true;
        if (s == null || s.isEmpty()) a = false;
        return a;
    }
}
