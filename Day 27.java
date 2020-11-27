/*
Partition Equal Subset Sum
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1)
            return false;
         int n = nums.length;
         return helper(nums,sum / 2,n);        
    }
    
    boolean helper(int nums[], int s,int n){
        boolean dp [][] = new boolean[n + 1][s + 1];
        
        for(int i = 0;i <= n;i++)
            dp[i][0] = true;
        
        for(int j = 1;j <= s;j++)
            dp[0][j] = false;
        
        for(int i = 1;i <= n;i++){
            for(int j = nums[i - 1];j <= s;j++){
                
                dp[i][j] = dp[i -1][j - nums[i - 1]] || dp[i - 1][j];
                
            }
        }
        return dp[n][s];
        
    }

}