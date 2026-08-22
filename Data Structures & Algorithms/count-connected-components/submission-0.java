class Solution {
    public static void BFS(List<List<Integer>> graph, int node, boolean vis[]){
        vis[node] = true;
        for(Integer nei: graph.get(node)){
            if(!vis[nei]){
                BFS(graph, nei, vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        
        }
        for(int i  = 0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int res = 0;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                BFS(graph, i, vis);
                res++;
            }
        }
        return res;

    }
}
