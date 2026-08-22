class Solution {
    static class Trie{
        Trie children[];
        boolean end;
        public Trie(){
            this.children = new Trie[26];
            this.end = false;
        }
    }

    public static void buildTrie(Trie root, String str){
        for(char ch: str.toCharArray()){
            int idx = ch-'a';
            if(root.children[idx] == null){
                root.children[idx] = new Trie();
            }
            root = root.children[idx];
        }
        root.end = true;
    }

    public static String searchPrefix(Trie root, StringBuilder ans){
        while(true){
            int idx = -1;
            int cnt = 0;
            for(int i = 0; i<26; i++){
                if(root.children[i] != null){
                    cnt++;
                    idx = i;
                }
            }

            if(cnt != 1)break;
            if(root.end == true)break;

            ans.append((char)('a' + idx));
            root = root.children[idx];
        }

        return ans.toString();
    } 
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Trie root = new Trie();

        for (String str : strs) {
            buildTrie(root, str);
        }

        StringBuilder ans = new StringBuilder();

        return searchPrefix(root, ans);
    }
}