class LFUCache {
    class Node{
        int key, value;
        Node next, prev;
        int cnt;

        Node(int key, int value){
            this.key= key;
            this.value= value;
            this.cnt=1;
        }

    }

    class DLL{
        Node head;
        Node tail;
        int size=0;


        DLL(){
            head= new Node(0,0);
            tail= new Node(0,0);
            size=0;
            head.next= tail;
            tail.prev= head;

        }

        void InsertAfterHead(Node node){
            Node temp= head.next;
            head.next= node;
            node.next= temp;
            temp.prev= node;
            node.prev= head;

            size++;

        }
        void DeleteBeforeTail(Node node){
            Node prevNode= node.prev;
            Node nextNode= node.next;
            prevNode.next= nextNode;
            nextNode.prev= prevNode;
            size--;

        }
    }


    Map<Integer, Node> hmap;
    Map<Integer, DLL> freqMap;
    int cap;
    int minFreq;
    int cursize;
    public LFUCache(int capacity) {
        cap=capacity;
        hmap= new HashMap<>();
        freqMap= new HashMap<>();
        minFreq=0;
        cursize=0;


        
    }
    void updateFreqMap(Node node){
        hmap.remove(node.key);
        DLL list= freqMap.get(node.cnt);

        list.DeleteBeforeTail(node);
        if(node.cnt== minFreq && list.size==0){
            minFreq++;
        }
        node.cnt++;

        DLL newList= freqMap.getOrDefault(node.cnt,new DLL());
        newList.InsertAfterHead(node);
        freqMap.put(node.cnt, newList);
        hmap.put(node.key, node);



    }
    
    public int get(int key) {
        int val;
        if(hmap.containsKey(key)){
            Node node= hmap.get(key);
            val= node.value;
            updateFreqMap(node);


            return val;

        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cap==0) return;
        if(hmap.containsKey(key)){
            Node node= hmap.get(key);
            node.value= value;
            updateFreqMap(node);
            return;
        }
        if(cursize == cap){
            DLL list= freqMap.get(minFreq);
            Node nodeTORemove= list.tail.prev;

            hmap.remove(nodeTORemove.key);
            list.DeleteBeforeTail(nodeTORemove);
            cursize--;
        }
        cursize++;
        minFreq= 1;
        Node newNode= new Node(key, value);
        DLL list= freqMap.getOrDefault(minFreq, new DLL());
        list.InsertAfterHead(newNode);
        hmap.put(key, newNode);
        freqMap.put(minFreq,list);
        return;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */