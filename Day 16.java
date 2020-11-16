/*
Longest Mountain in Array
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)
Given an array A of integers, return the length of the longest mountain. 
Return 0 if there is no mountain.

Example 1:
Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:
0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:
Can you solve it using only one pass?
Can you solve it in O(1) space?
*/
class Solution {
    public int longestMountain(int[] A) {
        int res = 0;
        for (int i = 1; i < A.length;) {
            if (A[i - 1] < A[i]) {
                int j = i;
                
                // go up
                while (j < A.length && A[j - 1] < A[j]) {
                    j ++;
                }
                if (j == A.length) break;
                
                // flat, duplicate numbers
                if (A[j - 1] == A[j]) {
                    i = j + 1;
                    continue;
                }
                
                // go down
                while (j < A.length && A[j - 1] > A[j]) {
                    j ++;
                }
                
                if (j - i > 1) {
                    res = Math.max(res, j - i + 1);
                }
                i = j;
                
            } else {
                i ++;
            }
        }        
        return res;
    }
}
/*
Using O(n) space
class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n == 0)
            return 0;
        int backwardPass[] = new int[n];
        int forwardPass[] = new int[n];
        
        for(int i = 1; i < n; i ++)
            if(A[i] > A[i - 1])
            backwardPass[i] = backwardPass[i - 1] + 1;
        for(int i = n - 2; i >= 0; i --)
            if(A[i] > A[i + 1])
            forwardPass[i] = forwardPass[i + 1] + 1;
        
        int ans = 0;
        for(int i = 0; i < n; i ++)
            if(backwardPass[i] > 0 && forwardPass[i] > 0) 
                ans = Math.max(ans, backwardPass[i] + forwardPass[i] + 1);
        
        return ans;   
    }
}
*/