class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            graph.get(u).add(v);
        }

        int idgr[] = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            for(int num: graph.get(i)){
                idgr[num]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<numCourses; i++){
            if(idgr[i] == 0)q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int nei: graph.get(curr)){
                idgr[nei]--;
                if(idgr[nei] == 0)q.add(nei);
            }
        }

        // for(int i = 0; i<numCourses; i++){
        //     if(idgr[i] != 0)return false;
        // }
       
        return cnt == numCourses;
    }
}
