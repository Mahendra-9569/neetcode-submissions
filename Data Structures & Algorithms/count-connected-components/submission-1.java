class Solution {
    static int par[];
    static int size[];
    public static int findPar(int x){
        if(par[x] == x)return x;
        return par[x] = findPar(par[x]); 
    }

    public void union(int u, int v){
        int u_par = findPar(u);
        int v_par = findPar(v);
        if( u_par == v_par)return;
        if(size[u_par] >= size[v_par]){
            par[v_par] = u_par;
            size[u_par] += size[v_par];
        }
        else{
            par[u_par] = v_par;
            size[v_par] += size[u_par];
        }

    }
    public int countComponents(int n, int[][] edges) {
      par = new int[n];
      size = new int[n];

      for(int i = 0; i<n; i++){
        par[i] = i;
        size[i] = 1;
      }

      for(int arr[]: edges){
        int u = arr[0];
        int v = arr[1];
        union(u, v);
      }
      Set<Integer> st = new HashSet<>();
      for(int i = 0; i<n; i++){
         st.add(findPar(i));
      }

      return st.size();
    }
}
