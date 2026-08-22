class Solution {
    class Obj implements Comparable<Obj>{
        int key;
        int val;
        public Obj(int key, int val){
            this.val = val;
            this.key = key;
        }
        @Override
        public int compareTo(Obj o){
            return o.val - this.val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
       }

       PriorityQueue<Obj> pq = new PriorityQueue<>();
       for(Integer i : map.keySet()){
        pq.add(new Obj(i, map.get(i)));

       }

       int ans[] = new int[k];
       for(int i = 0; i<k; i++){
        ans[i] = pq.remove().key;
       }

       return ans;
    }
}
