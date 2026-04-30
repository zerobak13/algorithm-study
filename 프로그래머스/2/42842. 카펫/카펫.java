import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total= brown+yellow;
        int[] answer =new int[2];
      
        int a=0;
        int b=0;
        int j=0;
        for(int i=3;i<=total;i++){
            if(total%i==0){
                j=total/i;
            }
                if(i*j==total){
                    if((i-2)*(j-2)==yellow){
                        a=i;
                        b=j;
                    }
                }
        }
        
            answer[0]=Math.max(a,b);
            answer[1]=Math.min(a,b);
        
       return answer;
    }
         
}