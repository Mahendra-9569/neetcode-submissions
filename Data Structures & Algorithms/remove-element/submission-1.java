class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
               idx++;
               int temp = nums[idx];
               nums[idx] = nums[i];
               nums[i] = temp;
              
            }
        }

        return idx+1;
    }
}