import java.util.HashMap;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev=null;
    }
}

public class LRUCache {

    HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
    Node tail;
    Node head;
    int count;
    public LRUCache(int capacity){
        this.capacity = capacity;
        head=null;
        tail=null;
        count=0;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            temp.prev.next =  temp.next;
            temp.next = head;
            head.prev = temp;
            temp.prev=null;
            head = temp;
            return head.data;
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(count==0){
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            hm.put(key, newNode);
            count++;
            return;
        }

        if(count<capacity){
            Node newNode = new Node(value);
            newNode.next = head;
            newNode.prev = null;
            if(head!=null){
                head.prev = newNode;
            }
            head=newNode;
            hm.put(key, newNode);
            count++;
        }else{
            Node temp = tail.prev;
            tail.prev.next=null;
            tail = temp;
        }
    }
}
