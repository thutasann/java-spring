# Sliding Window Notes

## calculate the maximum sum of a subarray having size exactly K.

```java
int[] arr = {2, 1, 5, 1, 3, 2};
int k = 3;

[2, 1, 5] → Sum = 8
[1, 5, 1] → Sum = 7
[5, 1, 3] → Sum = 9  ✅ (Max)
[1, 3, 2] → Sum = 6
```

- Maximum Sum = 9
- This means [5,1,3] is the subarray with the hightest sum

---

## General Approach

```java
int[] arr = { 2, 1, 5, 1, 3, 2 };
int k = 3;

// compute the sum of the first k elements
Initial window [2, 1, 5] → Sum = 8

// Remove 2 (leftmost) and add 1 (next element)
// We remove the first element (2) and add the next element in the array (1).
// Old window: [2, 1, 5]
// - Sum = 8 (from previous step)
// - Leftmost element = 2 (removing it)
// - Next element to be added = 1
// - New Sum = Previous Sum - Removed Element + New Element ✅
// - New Sum = Previous Sum - arr[i - k] + arr[i]
New window: [1, 5, 1] → Sum = 8 - 2 + 1 = 7

// Remove 1, add 3
New window: [5, 1, 3] → Sum = 7 - 1 + 3 = 9 (Max)

// Remove 5, add 2
New window: [1, 3, 2] → Sum = 9 - 5 + 2 = 6
```
