class MyHashSet {
    ArrayList<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }
    
    public void add(int key) {
        boolean flag = false;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == key){
                 flag = true;
            }
        }

        if(flag == false)list.add(key);
    }
    
    public void remove(int key) {
           list.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return list.contains(key)?true:false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */