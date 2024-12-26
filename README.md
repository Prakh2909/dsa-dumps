# dsa-dumps


## Binary Search
Binary Search Predicate Framework: https://www.youtube.com/watch?v=xQj48bab4HU start from 2.10 to get to Predicate framework directly.

Divide the search space into T*F* or F*T* targeting for seaching (last T/First F) or (First T/Last F) respectively
lower mid: lo + (hi-lo)/2 used when we are increaing the lo to mid + 1
upper mid: lo + (hi-lo+1)/2 used when we are decreasing the hi to mid -1
Time complexity = O(logn)
We can also use recursion to solve binary search but using that will require auxillary space in Function call stack, iterative approach is considered more efficient.
example: we have T*F* and we are looking for first F
Template:
```java
int lo = 0;
int hi = arrayLength - 1;

while(lo<hi){
    int mid = lo + (hi-lo+1)/2;

    if(P(mid)){
        lo = mid+1; // since we are increasing the lo to mid +1 we will use lower mid syntax and vice versa.
    }
    else{
        hi = mid;
    }
}

if(!P(mid)){
    return mid;
}
return -1;
```

## Sorting in Java
there are two ways to sort one is via collections and one is using Arrays. Collections sort only works on non-primitvies and Arrays one works for primitives and non primitives.
Arrays.sort(object); to sort an array
Arrays.sort(object,start, end); to sort a subarray
### Stability in Sorting Algos
- Stable algorithims not only sorts the array but also make sure if two items have same value they should be kept in the same order as of the orignal array.
- It is important when we are sorting objects based on multiple values unlike an integer array.
- Unstable algos dont care about the order, which is used in primitive types.

Example of stable algo: Bubble sort, Insertion sort, Merge sort
- Bubble sort swaps the adjacent items only in case if `i+1<i`. It does nothing in case of `i<=i+1`;

Example of unstable algo: selection sort, quick sort, heap sort
- Selection sort start with placing the largests items at the end. 

## Linked List
Linear Data structure, that does not require pre allocated memory and no need for contigous memory. Making insertion and deletion in between nodes efficient.
Best for Round Robin implementation

```java
// use this to create a LL node and then go ahead with linking other nodes
class Node{
    int data;
    Node next;
    Node(int x){
        this.data = x;
        next = null;
    }
}
```
Detecting a cycle in LL
- for every node we find if there is a node pointing to it.
- change the structure of node and add a boolean visited to mark them as visited or not.
- mark next of each node to a temp node and check if any node is already marked which means cycle exist.
- use a hashset to store every node and check if any node exist in the set or not.
- using floyd's cycle detection algo by creating slow and fast pointers.