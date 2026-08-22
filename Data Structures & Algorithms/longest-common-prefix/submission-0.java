class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int n = strs[0].length();
        int idx = 0;
        while(idx < n){
            if(idx >= strs[0].length())return ans.toString();
            char ch = strs[0].charAt(idx);

            for(int i = 1; i<strs.length; i++){
                if(idx >= strs[i].length()) return ans.toString();
                if(strs[i].charAt(idx) != ch) return ans.toString();
            }
            ans.append(ch);
            idx++;
        }

        return ans.toString();
    }
}