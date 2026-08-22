class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String ,List<String>> map = new LinkedHashMap<>();
        for(String s: strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        int cnt = 0;
        for(String s: map.keySet()){
            ans.add(map.get(s));
        }

        return ans;
    }
}
