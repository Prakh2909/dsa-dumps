public class LinkedList {
    public static void main(String[] args) {
        LLNode l1 = new LLNode(1);
        LLNode l2 = new LLNode(2);
        LLNode l3 = new LLNode(3);
        LLNode l4 = new LLNode(4);
        l1.next = l2;
        l1.next.next = l3;
        l1.next.next.next = l4;
        LLNode head = l1;
        traverse(head);
        head = insertAtStart(head, 0);
        traverseReursively(head);
        head = insertAtEnd(head, 5);
        traverseReursively(head);
        head = insertAtPos(head, 9, 2);
        traverse(head);
        head = deleteHeadNode(head);
        traverse(head);
        head = deleteLastNode(head);
        traverse(head);
        System.out.println(searchLL(head, 5));
    }

    public static void traverse(LLNode head){
        LLNode curr = head;
        while(curr !=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void traverseReursively(LLNode head){
        if(head==null){
            System.out.println();
            return;
        }
        System.out.print(head.data+" ");
        traverseReursively(head.next);
    }

    public static LLNode insertAtStart(LLNode head, int data){
        LLNode newNode = new LLNode(data);
        newNode.next = head;
        return newNode;
    }

    public static LLNode insertAtEnd(LLNode head, int data){
        LLNode newNode = new LLNode(data);
        if(head==null){
            return newNode;
        }
        LLNode curr = head;
        while(curr.next !=null){
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public static LLNode insertAtPos(LLNode head, int data, int pos){
        LLNode newNode = new LLNode(data);
        
        if(pos==1){
            newNode.next = head;
            return newNode;
        }

        int count = 1;
        LLNode curr = head;
        while(curr.next != null && count < pos-1){
            curr = curr.next;
            count++;
        }

        if(count==pos-1){
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    public static LLNode deleteHeadNode(LLNode head){
        if(head==null){
            return null;
        }
        head = head.next;
        return head;//head.next
    }

    public static LLNode deleteLastNode(LLNode head){
        if(head==null || head.next==null){
            return null;
        }
        LLNode curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }
        curr.next=null;
        return head;
    }

    public static int searchLL(LLNode head, int value){
        LLNode curr = head;
        int count=1;
        while(curr!=null){
            if(curr.data==value){
                return count; 
            }
            count++;
            curr=curr.next;
        }
        return -1;
    }
}
