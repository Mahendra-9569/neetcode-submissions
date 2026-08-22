class Solution {
    public static int countBit(int n){
        int cnt = 0;
        while(n > 0){
            if((1 & n) == 1)cnt++;
            n = n>>1;
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int ans[] = new int[n+1];

        for(int i = 0; i<=n; i++){
            int cnt = countBit(i);
            ans[i] = cnt;
        }

        return ans;
    }
}
