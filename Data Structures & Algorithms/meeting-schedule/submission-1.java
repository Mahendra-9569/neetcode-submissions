/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
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
            return this.first - p.first;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1)return true;
         PriorityQueue<Pair> pq = new PriorityQueue<>(); 
         for(Interval i: intervals){
              pq.add(new Pair(i.start, i.end));
         }
         Pair curr = pq.poll();
         int first = curr.first;
         int last = curr.last;
         while(!pq.isEmpty()){
            curr = pq.poll();
            int f = curr.first;
            int l = curr.last;
            if(f < last){
                return false;
            }
            else{
                first = f;
                last = l;
            }
         }
         return true;
    }
}
