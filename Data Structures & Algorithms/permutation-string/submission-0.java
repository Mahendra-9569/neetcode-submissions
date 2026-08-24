class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }
        int windowSize = s1.length();
        for (int i = 0; i < windowSize; i++) {
            f2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(f1, f2)) {
            return true;
        }
        for (int right = windowSize; right < s2.length(); right++) {
            f2[s2.charAt(right) - 'a']++;
            int left = right - windowSize;
            f2[s2.charAt(left) - 'a']--;
            if (Arrays.equals(f1, f2)) {
                return true;
            }
        }
        return false;
    }
}