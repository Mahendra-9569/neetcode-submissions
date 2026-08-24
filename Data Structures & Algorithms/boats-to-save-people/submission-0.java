class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int ans = 0;
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum > limit){
                if(people[right] <= limit){
                    ans++;
                }
                right--;
            }
            else{
                ans++;
                left++;
                right--;
            }
        }

        return ans;
    }
}