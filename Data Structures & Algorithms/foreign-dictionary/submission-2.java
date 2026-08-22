class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        int[] indegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int nei : graph.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.append((char) (curr + 'a'));
            for (int nei : graph.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] > 0) {
                return "";
            }
        }

        return ans.toString();
    }
}
