class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1])return nums[0];

        int start = 0;
        int end = nums.length-1;
        int mid;
        int ans = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            if(nums[mid] < nums[0]){
                ans = nums[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
}
