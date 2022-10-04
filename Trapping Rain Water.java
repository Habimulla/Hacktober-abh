/*
42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining. 
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
class Solution {
    public int trap(int[] height) {
        int h = height.length;
        int maxLeft[] = new int[h];
        int maxRight[] =new int[h];
        maxLeft[0] =height[0];
        maxRight[h-1]=height[h-1];
        for(int i=1;i<h;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        for(int i=h-2;i>=0;i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<h;i++){
            ans += Math.min(maxRight[i],maxLeft[i])-height[i];
        }
        return ans;
    }
}
