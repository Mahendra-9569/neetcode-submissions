class Solution {
    public static List<String> children(String lock){
        List<String> res = new ArrayList<>();
        for(int  i = 0; i<4; i++){
            char[] arr = lock.toCharArray();
            arr[i] = (char)(((arr[i]-'0'+1)%10)+'0');
            res.add(new String(arr));
            
            arr = lock.toCharArray();
            arr[i] = (char)(((arr[i]-'0'-1+10)%10)+'0');
            res.add(new String(arr));
        }

        return res;
    }
    public int openLock(String[] deadends, String target) {
        
        Set<String> vis = new HashSet<>(Arrays.asList(deadends));
        if(vis.contains("0000")){
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        vis.add("0000");
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                String str = q.poll();
                if(str.equals(target))return res;
                for(String lock: children(str)){
                    if(!vis.contains(lock)){
                        q.add(lock);
                        vis.add(lock);
                    }
                }
            }

            res++;
        }

        return -1;

    }
}