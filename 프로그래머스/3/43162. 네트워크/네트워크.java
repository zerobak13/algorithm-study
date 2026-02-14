import java.util.*;
class Solution {
    static boolean [] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n+1];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(int i, int[][]com, int n){
        visited[i]=true;
            for(int j=0;j<n;j++){
                 if(!visited[j]&&com[i][j]==1){
                    dfs(j,com,n);
                 }
            }        
    }
    
    
    
}