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
