/*************
Leet Code :740. Delete and Earn
Link :https://leetcode.com/problems/delete-and-earn/
Problem Statement :
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 
Constraints:
1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104
*************/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n =10001;
        int bucket[] = new int[n];
        for(int i :nums){
            bucket[i] +=i;
        }
        int prev1 =0,prev2=0,temp=0;
        for(int i=1;i<n;i++){
            temp =Math.max(bucket[i]+prev2,prev1);
            prev2=prev1;
            prev1 =temp;
        }
        return prev1;
    }
}
/**
Runtime: 5 ms, faster than 55.93% of Java online submissions for Delete and Earn.
Memory Usage: 44.7 MB, less than 25.10% of Java online submissions for Delete and Earn.
**/
// Sol -2//
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+n);
        }
        int m=map.size();
        int[] dp=new int[m];
        int[] arr=new int[m];
        {
            int i=0;
            for(int n:map.keySet()){
                arr[i++]=n;
            }
        }
        Arrays.sort(arr);
        dp[0]=map.get(arr[0]);
        for(int i=1;i<m;i++){
            if(arr[i]-1!=arr[i-1]){
                dp[i]=dp[i-1]+map.get(arr[i]);
            }else{
                dp[i]=(i==1?0:dp[i-2])+map.get(arr[i]);
            }
            dp[i]=Math.max(dp[i],dp[i-1]);
        }
        return dp[m-1];
    }
}
/**
48 / 48 test cases passed.
Status: Accepted
Runtime: 7 ms
Memory Usage: 44.5 MB
**/
///Sol-3
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n =10001;
        int bucket[] = new int[n];
        for(int i :nums){
            bucket[i] +=i;
        }
        int dp[] = new int[n];
        dp[0] =bucket[0];
        dp[1] =bucket[1];
        for(int i=2;i<n;i++){
            dp[i] = Math.max(bucket[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
/**
48 / 48 test cases passed.
Status: Accepted
Runtime: 6 ms
Memory Usage: 47.3 MB
**/
