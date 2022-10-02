class Solution {
    public int maxArea(int[] height) {
        
        int area = 0;
        int len = height.length;
        int end = len-1;
        
        for(int i=0;i<end;i++) {
            if(height[i]<height[end])
                area = Math.max(area, height[i]*(end - i));
            else {
                area = Math.max(area, height[end]*(end - i));
                --end;
                --i;
            }
        }
        
        return area;    
        
    }
}
