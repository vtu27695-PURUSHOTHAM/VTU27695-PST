import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            int[] left = new int[26];
            int[] right = new int[26];

            int mid = n / 2;

            for (int i = 0; i < mid; i++) {
                left[s.charAt(i) - 'a']++;
            }

            int start = (n % 2 == 0) ? mid : mid + 1;

            for (int i = start; i < n; i++) {
                right[s.charAt(i) - 'a']++;
            }

            System.out.println(Arrays.equals(left, right) ? "YES" : "NO");
        }

        sc.close();
    }
}
