class Solution {

    private static final int K = 26;

    public String foreignDictionary(String[] words) {

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < K; i++) graph.add(new HashSet<>());

        boolean[] present = new boolean[K];

        for (String w : words)
            for (char c : w.toCharArray())
                present[c - 'a'] = true;

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        int[] indegree = new int[K];
        for (int i = 0; i < K; i++)
            for (int nei : graph.get(i))
                indegree[nei]++;

        Deque<Integer> q = new ArrayDeque<>();
        int presentCount = 0;

        for (int i = 0; i < K; i++) {
            if (present[i]) {
                presentCount++;
                if (indegree[i] == 0) q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append((char) (curr + 'a'));
            for (int nei : graph.get(curr)) {
                if (--indegree[nei] == 0) q.add(nei);
            }
        }

        return sb.length() == presentCount ? sb.toString() : "";
    }
}
