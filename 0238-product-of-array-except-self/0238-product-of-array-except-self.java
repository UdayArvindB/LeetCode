class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int left = 1; left < n; left++){
            res[left] = res[left-1] * nums[left-1];
        }
        int rightProd=1;
        for(int right = n-1; right >= 0; right--){
            res[right] = res[right] * rightProd;
            rightProd *= nums[right];
        }
        return res;
    }
}