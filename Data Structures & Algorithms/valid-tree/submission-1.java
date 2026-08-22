class Solution {

    private boolean isCycle(List<List<Integer>> graph, boolean vis[], int node, int parent) {
        vis[node] = true;
        for (int nei : graph.get(node)) {
            if (!vis[nei]) {
                if (isCycle(graph, vis, nei, node)) return true;
            } else if (nei != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] arr : edges) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        boolean vis[] = new boolean[n];
        if (isCycle(graph, vis, 0, -1)) return false;

        for (boolean v : vis) if (!v) return false;

        return true;
    }
}
