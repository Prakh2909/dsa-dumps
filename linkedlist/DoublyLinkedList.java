public class DoublyLinkedList {
    public static void main(String[] args) {
        DLNode l1 = new DLNode(10);
        l1.next = new DLNode(20);
        l1.next.next = new DLNode(30);
        l1.next.prev = l1;
        l1.next.next.prev = l1.next;
        l1.prev = null;
        DLNode head = l1;
        traverse(head);
        head = insertAtStart(head, 9);
        traverse(head);
        head = insertAtEnd(head, 40);
        traverse(head);
        head = reverseDLL(head);
        traverse(head);
        head = deleteHeadNode(head);
        traverse(head);
        head=deleteLastNode(head);
        traverse(head);
    }

    public static void traverse(DLNode head){
        DLNode curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static DLNode insertAtStart(DLNode head, int data){
        DLNode newNode = new DLNode(data);
        newNode.next = head;
        if(head!=null){
            head.prev = newNode;
        }
        newNode.prev = null;
        return newNode;
    }

    public static DLNode insertAtEnd(DLNode head, int data){
        DLNode newNode = new DLNode(data);
        if(head==null){
            return newNode;
        }

        DLNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static DLNode reverseDLL(DLNode head){
        if(head==null || head.next==null){
            return head;
        }
        DLNode curr = head;
        DLNode temp = null;
        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }
    
    public static DLNode deleteHeadNode(DLNode head){
        if(head==null || head.next==null){
            return null;
        }

        head.next.prev = null;
        return head.next;
    }

    public static DLNode deleteLastNode(DLNode head){
        if(head==null || head.next==null){
            return null;
        }

        DLNode curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }

        curr.next.prev = null;
        curr.next=null;
        return head;
    }
}
