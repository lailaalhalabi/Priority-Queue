# PriorityQueue

Comparison between the sorted and unsorted implementation of an array-based priority Queue.
The methods used for the comparision are insert(K, V) and removeMin(K, V), and an ArrayList class was implemented to store the entries.

---

## Time Complexities:

### Sorted Priority Queue:

Insert(K, V): O(n)

removeMin(K, V): O(1)

### Unsorted Priority Queue:

Insert(K, V): O(1)

removeMin(K, V): O(n)

---

## Analysis:

The sorted priority queues are more efficient than the unsorted queues in term of time complexity when removing the min value. Removing the minimum element takes more time when the priority queue is unsorted, so it must compare all the keys of the items to get the min value. Inserting when the list is sorted will take more time O(n), but the min value will be removed at index 0, which makes the time complexity of removing more efficient O(1).
