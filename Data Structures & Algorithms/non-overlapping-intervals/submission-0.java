class Solution {
    static class Pair implements Comparable<Pair>{
        int first;
        int last;
        public Pair(int f, int l){
            first = f;
            last = l;
        }

        @Override
        public int compareTo(Pair p){
            if(this.first != p.first){
                return this.first - p.first;
            }
            return this.last - p.last;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int arr[]: intervals){
            pq.add(new Pair(arr[0], arr[1]));
        }
        Pair curr = pq.poll();
        int first  = curr.first;
        int last = curr.last;
        int ans = 0;
        while(!pq.isEmpty()){
            curr = pq.poll();
            int f = curr.first;
            int l = curr.last;
            if(f < last){
                ans++;
                last = Math.min(l, last);
            }else{
                last = l;
            }
        }

        return ans;
    }
}
