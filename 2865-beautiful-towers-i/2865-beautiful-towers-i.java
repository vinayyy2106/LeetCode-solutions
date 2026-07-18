class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long ans = 0;
        for (int peak = 0; peak < n; peak++) {
            long sum = heights[peak];
            int minHeight = heights[peak];
            for (int i = peak - 1; i >= 0; i--) {
                minHeight = Math.min(minHeight, heights[i]);
                sum += minHeight;
            }
            minHeight = heights[peak];
            for (int i = peak + 1; i < n; i++) {
                minHeight = Math.min(minHeight, heights[i]);
                sum += minHeight;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}