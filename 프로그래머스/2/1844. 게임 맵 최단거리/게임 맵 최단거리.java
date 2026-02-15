import java.util.*;
class Solution {
        static boolean[][]visited;
        static int n;
        static int m;
        static int result=-1;
        static int[]dx=new int[]{-1,1,0,0};
        static int[]dy=new int[]{0,0,-1,1};
        public int solution(int[][] maps) {
            int answer = 0;
            n=maps.length;
            m=maps[0].length;
            visited=new boolean[n][m];
            visited[0][0]=true;
            bfs(0,0,1,maps);
            answer=result;

            return answer;
        }
        static void bfs(int x,int y,int dist, int[][]maps){
            Queue<int[]>q=new LinkedList<>();
            q.add(new int[]{x,y,dist});
            while(!q.isEmpty()){
                int[]cur=q.poll();
                int cx=cur[0];
                int cy=cur[1];
                int c_dist=cur[2];
                if(cx==n-1&&cy==m-1){
                    result=c_dist;
                    return;
                }
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(maps[nx][ny]!=0&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny,c_dist+1});

                    }
                }
            }
        }
    }
}
