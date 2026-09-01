class Solution {

    static void search(String pattern, String text) {

        int m = pattern.length();
        int n = text.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // Compare pattern with text
            while (j < m &&
                   text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            // Pattern found
            if (j == m) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        search(pattern, text);
    }
}
