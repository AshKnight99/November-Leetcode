/*
 Longest Substring with At Least K Repeating Characters

Solution
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is less than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
*/
lass Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n == 0 || n < k)
            return 0;
        if(k == 0 || k == 1)
            return n;
        
        char arr[] = s.toCharArray();
        int[] freqArr = new int[26];
        boolean existingFreq = false;
        
        for(char ch : arr){
            freqArr[ch - 'a'] ++;
            if(freqArr[ch - 'a'] == k)
                existingFreq = true;
        }
        if(!existingFreq)
            return 0;
        
        int  i = 0;
        while(i < n && freqArr[arr[i] - 'a'] >= k)
            i ++;
        
        if(i >= n - 1)
            return i;
        
        int l1 = longestSubstring(s.substring(0,i),k);
        
        
        while(i < n && freqArr[arr[i] - 'a'] < k)
            i ++;
        
        int l2 = (i >= n) ? 0 : longestSubstring(s.substring(i,n),k);           
  
        return Math.max(l1,l2);
    }
}