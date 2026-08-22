class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 32; i++){
            int last = n & 1;
            sb.append(last);
            n = n >>> 1;
        }

        return (int) Long.parseLong(sb.toString(), 2);
    }
}