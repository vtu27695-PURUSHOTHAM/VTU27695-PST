import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            // Add element to window and update element frequency count
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Once the window reaches size M
            if (deque.size() == m) {
                // Track maximum unique element count
                if (map.size() > maxUnique) {
                    maxUnique = map.size();
                }

                // Early exit optimization
                if (maxUnique == m) {
                    System.out.println(maxUnique);
                    return;
                }

                // Remove oldest element from the queue
                int removed = deque.removeFirst();
                int count = map.get(removed);

                // Update frequency map without calling deque.contains()
                if (count == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, count - 1);
                }
            }
        }

        System.out.println(maxUnique);
    }
}
