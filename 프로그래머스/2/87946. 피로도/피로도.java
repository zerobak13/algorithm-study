class Solution {
    static boolean []visited;
    static int result=Integer.MIN_VALUE;
    static int n;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int count=0;
        n=dungeons.length;
        visited=new boolean[n];
        dfs(k,dungeons,0);
        answer=result;
        return answer;
    }
    static void dfs(int k,int[][]dungeons, int count){
        
        result=Math.max(result,count);      
        
        for(int i=0;i<n;i++){
             if(!visited[i]){
                 if(dungeons[i][0]<=k){
                     visited[i]=true;
                     dfs(k-dungeons[i][1], dungeons,count+1);
                     visited[i]=false;
                 }
             }          
        }
       
        
    }
}
