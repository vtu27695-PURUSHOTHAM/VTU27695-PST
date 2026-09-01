import java.util.*;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int current = arr.get(0);
        int maxSub = arr.get(0);

        int maxNonContiguous = arr.get(0);

        // Kadane's algorithm
        for (int i = 1; i < arr.size(); i++) {

            int value = arr.get(i);

            current = Math.max(value, current + value);
            maxSub = Math.max(maxSub, current);

            maxNonContiguous =
                Math.max(maxNonContiguous,
                         maxNonContiguous + value);
        }

        // Correct non-contiguous calculation
        maxNonContiguous = 0;
        int largest = arr.get(0);

        for (int value : arr) {
            if (value > 0) {
                maxNonContiguous += value;
            }

            largest = Math.max(largest, value);
        }

        if (maxNonContiguous == 0) {
            maxNonContiguous = largest;
        }

        return Arrays.asList(maxSub, maxNonContiguous);
    }
}
