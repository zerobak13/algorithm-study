import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.add(new int[]{i,priorities[i]});
        }
        
        while(!q.isEmpty()){
            boolean check=false;
            int[]curr=q.poll();
            for(int[]x:q){
                if(x[1]>curr[1]){
                    check=true;
                    break;
                }
            }
            if(check){
                q.add(curr);
            }
            else{                
                answer++;
                  if(location==curr[0]){
                return answer;
                 }
             }
          
        }
        return answer;
        
    }
}