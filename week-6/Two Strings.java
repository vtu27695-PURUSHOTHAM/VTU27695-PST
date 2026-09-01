class Result {

    public static String twoStrings(String s1, String s2) {

        boolean[] present = new boolean[26];

        for (char c : s1.toCharArray()) {
            present[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (present[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }
}
