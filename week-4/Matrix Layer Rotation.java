import java.util.*;

public class Solution {

    public static void matrixRotation(
            List<List<Integer>> matrix, int r) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> values = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = rows - layer - 1;
            int right = cols - layer - 1;

            // Top row
            for (int j = left; j <= right; j++)
                values.add(matrix.get(top).get(j));

            // Right column
            for (int i = top + 1; i <= bottom; i++)
                values.add(matrix.get(i).get(right));

            // Bottom row
            for (int j = right - 1; j >= left; j--)
                values.add(matrix.get(bottom).get(j));

            // Left column
            for (int i = bottom - 1; i > top; i--)
                values.add(matrix.get(i).get(left));

            int size = values.size();
            int rotation = r % size;

            int index = rotation;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j, values.get(index));
                index = (index + 1) % size;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, values.get(index));
                index = (index + 1) % size;
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j, values.get(index));
                index = (index + 1) % size;
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, values.get(index));
                index = (index + 1) % size;
            }
        }

        // Print matrix
        for (List<Integer> row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
