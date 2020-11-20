/*
Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.
Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        int val = 0;
        while(start <= end){
            mid = (start + end ) / 2; 
            val = nums[mid];
            if(val == target)
                return true;
            else if(nums[start] == val && nums[end] == val){
                start ++;
                end --;
              }
            else if(val >= nums[start]){
                if(target < val && target >= nums[start])
                   end = mid - 1;
                else
                    start = mid + 1;                
            }
            else{
                if(target > val && target <= nums[end])
                   start = mid + 1;
                else
                    end = mid - 1; 
            }
        }
        return false;        
    }
}