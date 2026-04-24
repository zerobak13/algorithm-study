import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x=sizes.length;
        int max_a=0;
        int max_b=0;
        for(int i=0;i<x;i++){
           int a=Math.max(sizes[i][0],sizes[i][1]);
           int b=Math.min(sizes[i][0],sizes[i][1]);
           if(a>max_a){
               max_a=a;
           }
           if(b>max_b){
               max_b=b;
           }
        }
        answer=max_a*max_b;
        
        return answer;
    }
}