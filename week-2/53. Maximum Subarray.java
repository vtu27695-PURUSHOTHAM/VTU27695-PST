class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either add current element to existing subarray or start a new subarray at nums[i]
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Track the highest maximum sum seen across all subarrays
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
