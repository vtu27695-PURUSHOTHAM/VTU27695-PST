import java.util.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {

        int n = s.length();

        List<Integer> result = new ArrayList<>();

        // Double the string to handle circular wrapping
        String doubled = s + s;

        for (int start = 0; start < n; start++) {

            int maxLength = 1;

            // Try every possible length
            for (int len = 1; len <= n; len++) {

                int left = start;
                int right = start + len - 1;

                if (isPalindrome(doubled, left, right)) {
                    maxLength = len;
                }
            }

            result.add(maxLength);
        }

        return result;
    }

    private static boolean isPalindrome(
            String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
