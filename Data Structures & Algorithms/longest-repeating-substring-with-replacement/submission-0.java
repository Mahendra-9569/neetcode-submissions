class Solution {
    public static int getMax(Map<Character, Integer> map){
        int max = Integer.MIN_VALUE;
        for(Character k: map.keySet()){
            if(map.get(k) > max){
                max = map.get(k);
            }
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int left  = 0;
        for(int right = 0; right<s.length(); right++){
           map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
           while((right-left+1) - getMax(map) > k){
            map.put(s.charAt(left), map.get(s.charAt(left))-1);
            left++;
           }

           ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
