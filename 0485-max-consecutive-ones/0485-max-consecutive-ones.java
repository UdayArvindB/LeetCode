class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current_count=0;
        int max_count=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                current_count++;
            }else{
                max_count=Math.max(max_count, current_count);
                current_count=0;
            }
        }
        return Math.max(max_count, current_count);
    }
}