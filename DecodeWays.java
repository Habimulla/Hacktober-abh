class Solution {
   
    public int numDecodings(String s) {
        int [] dp=new int[s.length()+1];
        return solve(dp,s,0);
    }
    public  int solve(int []dp,String s,int idx){
        if(idx==s.length()) return 1;
        if(dp[idx]!=0) return dp[idx];
        if(s.charAt(idx)=='0') return 0;
        int ans=solve(dp,s,idx+1);
        if(s.charAt(idx)=='1' && idx+1<s.length() && s.charAt(idx+1)<='9'){
            ans+=solve(dp,s,idx+2);
        }else if(s.charAt(idx)=='2' && idx+1<s.length() && s.charAt(idx+1)<='6'){
            ans+=solve(dp,s,idx+2);
        }
        return dp[idx]=ans;
    }
}
