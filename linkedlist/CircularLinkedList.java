public class CircularLinkedList {
    public static void main(String[] args) {
        LLNode head = new LLNode(10);
        head.next = new LLNode(20);
        head.next.next = new LLNode(30);
        head.next.next.next = new LLNode(40);
        head.next.next.next.next = head;
        traverse(head);
        head = insertAtStart(head, 1);
        traverse(head);
        head = insertAtStartBySwappingWithHead(head, 0);
        traverse(head);
        head = insertAtEnd(head, 50);
        traverse(head);
        head = deleteHead(head);
        traverse(head);
        head = deleteHeadBySwapping(head);
        traverse(head);
        head = deleteKthNode(head, 3);
        traverse(head);
    }

    public static void traverse(LLNode head){
        if(head==null) return ;
        LLNode curr = head.next;
        System.out.print(head.data+" ");
        while(curr!=head){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();

        //We can use do while loop too
        // curr=head;
        // do{
        //     System.out.println(curr.data);
        //     curr = curr.next;
        // }while(curr!=head);
    }

    public static LLNode insertAtStart(LLNode head, int data){ // we can make it better by also having a tail pointer or just by having a tail pointer
        // one more trick way to do is to insert a node next to head node and swap their values
        LLNode newNode = new LLNode(data);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }

        LLNode curr = head;
        while(curr.next!=head){
            curr=curr.next;
        }

        curr.next = newNode;
        newNode.next = head;
        return newNode;
    }

    public static LLNode insertAtStartBySwappingWithHead(LLNode head, int data){
        LLNode newNode = new LLNode(data);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }

        int temp = newNode.data;
        newNode.data = head.data;
        head.data = temp;
        newNode.next = head.next;
        head.next = newNode;
        return head;
    }

    public static LLNode insertAtEnd(LLNode head, int data){ // done using swapping style
        LLNode newNode = new LLNode(data);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }

        int temp = head.data;
        head.data = newNode.data;
        newNode.data = temp;
        newNode.next = head.next;
        head.next = newNode;
        return newNode;
    }

    public static LLNode deleteHead(LLNode head){
        if(head==null || head.next==head){
            return null;
        }

        LLNode curr = head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next = curr.next.next;
        head = curr.next;
        return head;
    }

    public static LLNode deleteHeadBySwapping(LLNode head){
        // idea is to swap the values with head.next and delete the head.next node
        if(head==null || head.next==head){
            return null;
        }

        int temp = head.next.data;
        head.next.data = head.data;
        head.data = temp;
        head.next = head.next.next;
        return head;
    }

    public static LLNode deleteKthNode(LLNode head, int k){
        if(head==null){
            return null;
        }

        if(k==1){
            return deleteHeadBySwapping(head);
        }

        LLNode curr=head;
        while(curr.next!=head && k-1>1){
            curr=curr.next;
            k--;
        }
        curr.next = curr.next.next;
        return head;


    }
}
