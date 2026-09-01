class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        // Transform string
        // Example: "aba" -> "^#a#b#a#$"
        StringBuilder sb = new StringBuilder();

        sb.append('^');

        for (char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }

        sb.append("#$");

        String t = sb.toString();

        int[] p = new int[t.length()];

        int center = 0;
        int right = 0;

        int maxLength = 0;
        int maxCenter = 0;

        for (int i = 1; i < t.length() - 1; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center
            while (t.charAt(i + (1 + p[i])) ==
                   t.charAt(i - (1 + p[i]))) {

                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {

                center = i;
                right = i + p[i];
            }

            // Track maximum palindrome
            if (p[i] > maxLength) {

                maxLength = p[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLength) / 2;

        return s.substring(start, start + maxLength);
    }
}
