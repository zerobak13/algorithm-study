import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][]fire;
    static int[][]jihun;
    static char[][]maze;
    static int R;
    static int C;
    static Queue<int[]>fire_q=new LinkedList<>();
    static Queue<int[]>jihun_q=new LinkedList<>();
    static int[]dx=new int[]{-1,1,0,0};
    static int[]dy=new int[]{0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();

        maze=new char[R][C];
        fire=new int[R][C];
        jihun=new int[R][C];

        for(int i=0;i<R;i++){
            String line=sc.next();
            for(int j=0;j<C;j++){
                maze[i][j]=line.charAt(j);
            }
        }
        for(int i=0;i<R;i++){
            Arrays.fill(fire[i],-1);
            Arrays.fill(jihun[i],-1);

        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) {
                if(maze[i][j]=='J'){
                    jihun[i][j]=0;
                    jihun_q.add(new int[]{i,j});
                }
                else if(maze[i][j]=='F'){
                    fire[i][j]=0;
                    fire_q.add(new int[]{i,j});
                }
            }
        }
        bfs_fire();
        bfs_jihun();


    }
    static void bfs_fire(){
        while(!fire_q.isEmpty()) {
            int[] curr = fire_q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if(maze[nx][ny]!='#'&&fire[nx][ny]==-1) {
                        fire[nx][ny] = fire[x][y] + 1;
                        fire_q.offer(new int[]{nx, ny});
                    }
                }
            }

        }

    }
    static void bfs_jihun(){
        while(!jihun_q.isEmpty()) {
            int[] curr = jihun_q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx <0 || ny <0 || nx >= R || ny >=C) {
                    System.out.println(jihun[x][y]+1);
                    return;
                }
                int nextTime=jihun[x][y]+1;
                if (maze[nx][ny]!='#'&&jihun[nx][ny]==-1) {
                    if(fire[nx][ny]==-1||fire[nx][ny]>nextTime){
                        jihun[nx][ny]=jihun[x][y]+1;
                        jihun_q.offer(new int[]{nx,ny});
                    }
                }

            }


        }
        System.out.println("IMPOSSIBLE");
    }

}