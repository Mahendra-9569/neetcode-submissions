class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long sum = 0;

        while (num != 0) {
            int r = num % 10;
            sum = sum * 10 + r;
            num = num / 10;
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }

        if (x < 0) {
            return -(int)sum;
        }

        return (int)sum;
    }
}