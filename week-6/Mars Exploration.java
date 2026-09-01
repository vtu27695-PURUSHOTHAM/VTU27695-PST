class Result {

    public static int marsExploration(String s) {

        String expected = "SOS";
        int changes = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != expected.charAt(i % 3)) {
                changes++;
            }
        }

        return changes;
    }
}
