public class LinkedListSolutions {
    public static void main(String[] args) {
        LLNode l1 = new LLNode(10);
        LLNode l2 = new LLNode(20);
        LLNode l3 = new LLNode(20);
        LLNode l4 = new LLNode(40);
        LLNode l5 = new LLNode(50);
        l1.next = l2;
        l1.next.next = l3;
        l1.next.next.next = l4;
        l1.next.next.next.next = l5;

        LLNode b = new LLNode(15);
        b.next = new LLNode(25);
        b.next.next=new LLNode(35);
        b.next.next.next=new LLNode(45);
        // l5.next=l2; // for cycle detection
        LLNode head = l1;
        traverse(head);
        System.out.println(findMiddleOfLinkedList(head));
        head = sortedInsertInALinkedList(head, 55);
        traverse(head);
        System.out.println(findMiddleOfLinkedList(head));
        traverse(head);
        System.out.println(nthNodeFromEnd(head, 7));
        head = reverseLLIterative(head);
        traverse(head);
        head = reverseLLUsingRecursion1(null, head);
        traverse(head);
        head = removeDuplicates(head);
        traverse(head);
        head = reverseFirstKNodes(head, 2);
        // System.out.println(detectCycle(head)); // for cycle detection
        traverse(head);
        // head = detectAndRemoveCycle(head);
        // traverse(head);
        traverse(b);
        traverse(l1);
        head = mergerTwoLL(l1, b);
        traverse(head);
    }

    public static void traverse(LLNode head){
        LLNode curr = head;
        while(curr !=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static LLNode sortedInsertInALinkedList(LLNode head, int x){
        LLNode newNode = new LLNode(x);
        if(head==null){
            return newNode;
        }

        LLNode curr = head;
        while(curr.next!=null && curr.next.data<x){
            curr=curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    public static int findMiddleOfLinkedList(LLNode head){
        if(head==null) return -1;
        if(head.next==null) return head.data;
        
        LLNode slow = head;
        LLNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static int nthNodeFromEnd(LLNode head, int n){
        if(head==null) return -1;
        if(n==0) return -1;
        LLNode slow = head;
        LLNode fast = head;
        while(fast!=null && n>1){
            fast=fast.next;
            n--;
        }
        if(fast==null){
            return -1;
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }

    public static LLNode reverseLLIterative(LLNode head){
        if(head==null) return null;

        LLNode curr=head;
        LLNode prev = null;
        while(curr!=null){
            LLNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static LLNode reverseLLUsingRecursion1(LLNode prev, LLNode curr){
        if(curr==null) return prev;

        LLNode next = curr.next;
        curr.next = prev;
        return reverseLLUsingRecursion1(curr, next);
    }

    public static LLNode removeDuplicates(LLNode head){
        if(head==null || head.next == null){
            return head;
        }

        LLNode curr = head;
        while(curr !=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static LLNode reverseFirstKNodes(LLNode head, int k){
        int count=0;

        LLNode prev=null,next=null;
        LLNode curr = head;
        while(curr!=null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        head.next = curr;
        if(next!=null){
            LLNode restHead = reverseFirstKNodes(next, k);
            head.next=restHead;
        }
        return prev;
    }

    public static boolean detectCycle(LLNode head){
        LLNode slow = head;
        LLNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static LLNode  detectAndRemoveCycle(LLNode head){
        if(head==null) return head;
        if(head.next==head){
            head.next=null;
            return head;
        }

        LLNode slow = head;
        LLNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return head;
        }
        slow=head;
        while(slow.next != fast.next){
            slow = slow.next;
            fast=fast.next;
        }
        fast.next=null;
        return head;
    }

    public static LLNode seggregateEvenAndOddNodes(LLNode head){
        LLNode es=null,ee=null,os=null,oe=null;

        LLNode curr = head;
        while(curr!=null){
            int x=curr.data;
            if(x%2==0){
                if(es==null){
                    es=curr;
                    ee=curr;
                }else{
                    ee.next=curr;
                    ee=ee.next;
                }
            }else{
                if(os==null){
                    os=curr;
                    oe=curr;
                }else{
                    oe.next=curr;
                    oe=oe.next;
                }
            }
        }

        if(os==null || es==null){
            return head;
        }

        ee.next = os;
        oe.next = null;
        return es;
    }

    public static LLNode mergerTwoLL(LLNode a,LLNode b){
        if(a==null) return b;
        if(b==null) return a;

        LLNode head=null, tail=null;

        if(a.data<=b.data){
            head=tail=a;
            a=a.next;
        }else{
            head=tail=b;
            b=b.next;
        }

        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next = a;
                tail=a;
                a=a.next;
            }else{
                tail.next = b;
                tail=b;
                b=b.next;
            }
        }

        if(a==null){
            tail.next=b;
        }else{
            tail.next=a;
        }
        return head;
    }

}
