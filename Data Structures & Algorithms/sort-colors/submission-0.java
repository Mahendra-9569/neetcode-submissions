class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int s = 0;
        int e = nums.length-1;
        while(i <= e){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[s];
                nums[s] = temp;
                s++;
                i++;
            }
            else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[e];
                nums[e] = temp;
                e--;
            }

            else{
                i++;
            }
        }

    }
}