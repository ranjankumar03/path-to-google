import java.util.Arrays;

public class CommonSubstrings {

    private static final int MAX_CHAR = 26;

    private static boolean isCommonSubstring(String str1, String str2) {

        boolean[] bool = new boolean[MAX_CHAR];
        Arrays.fill(bool, false);

        for (int i = 0; i < str1.length(); i++) {
            bool[str1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (bool[str2.charAt(i) - 'a'])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "world";

        System.out.println(isCommonSubstring(str1, str2));
    }
}
