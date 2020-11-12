/*
Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
class Solution {
    List<List<Integer>> permutatedList;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int map[] = new int[21]; // -10 to 10
        for(int v : nums)
            map[v + 10] ++;
        permutatedList = new ArrayList<>();
        int n = nums.length;
        permutations(n,nums,map,new ArrayList<Integer>());
        return permutatedList;
    }
    private void permutations(int n,int nums[],int map[],ArrayList<Integer> list){
        if(list.size() == n){
            permutatedList.add(new ArrayList<>(list));
            return;
        }
       // System.out.print(list);
        for(int i = 0;i < 21;i++){
            if(map[i] == 0)
                continue;
            map[i ] --;
            list.add(i - 10);
            permutations(n,nums,map,list);
            list.remove(list.size() - 1);
            map[i] ++;            
        }
    }
}