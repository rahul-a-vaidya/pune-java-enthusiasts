package ct.fp.example3;

class StringUtil {

    public static int length(String s) {
        System.out.println("calculating length for " + s);
        return s.length();
    }

    public static String toUpper(String s) {
        System.out.println("converting to uppercase for " + s);
        return s.toUpperCase();
    }
}
