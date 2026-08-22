class Solution {
    public static int findPivot(int nums[], int s, int e){
        int pivot = s-1;
        int last = nums[e];
        for(int i = s; i<e; i++){
            if(nums[i] < last){
            pivot++;
            int temp = nums[i];
            nums[i] = nums[pivot];
            nums[pivot] = temp;

        }
        }
        pivot++;
        int temp = nums[pivot];
        nums[pivot] = last;
        nums[e] = temp;

        return pivot;
    }
    public static void quickSort(int nums[], int s, int e){
        if(s>=e)return;
        int pivot = findPivot(nums, s, e);
        quickSort(nums, s, pivot-1);
        quickSort(nums, pivot+1, e);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
}