import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long left=0;
        long right=(long)times[times.length-1]*n;
         long answer = right;
        
        while(left<=right){
            long total=0;
            long mid=(left+right)/2;
            
            for(long x:times){
                total+=mid/x;
            }
            if(total>=n){
                right=mid-1;
                answer=Math.min(answer,mid);
            }
            else{
                left=mid+1;
            }
        }
        
        
        return answer;
    }
}