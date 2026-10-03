class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long windowSum = 0;
        long maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k) {
                int removed = nums[i - k];
                windowSum -= removed;
                map.put(removed, map.get(removed) - 1);
                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }
            if (i >= k - 1 && map.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }
}