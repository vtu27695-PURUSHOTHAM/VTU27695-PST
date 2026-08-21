import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of lines
        int n = scanner.nextInt();
        
        // Create an ArrayList of ArrayLists to store dynamic lines
        List<List<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }
        
        // Read the number of queries
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            // HackerRank uses 1-based indexing for x and y
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            try {
                // Convert 1-based index to 0-based index
                System.out.println(lines.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}
