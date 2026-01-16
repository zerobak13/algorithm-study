import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][]box;
    static int M;
    static int N;
    static int H;
    //상하좌우 위아래
    static int[]dx={-1,1,0,0,0,0};
    static int[]dy={0,0,-1,1,0,0};
    static int[]dz={0,0,0,0,-1,1};
    static int result=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        M=sc.nextInt();
        N=sc.nextInt();
        H=sc.nextInt();
        box=new int[H][N][M];
        for(int z=0;z<H;z++){
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    box[z][x][y]=sc.nextInt();
                }
            }
        }
        bfs();
        for(int z=0;z<H;z++){
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    if(box[z][x][y]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);


    }
    static void bfs(){
        Queue<int[]>q=new LinkedList<>();
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (box[z][x][y] == 1) {
                        q.offer(new int[]{z, x, y, 0});
                    }
                }
            }
        }
        while(!q.isEmpty()) {
            int[]curr=q.poll();
            int z=curr[0];
            int x=curr[1];
            int y=curr[2];
            int days=curr[3];
            result=Math.max(result,days);
            for(int i=0;i<6;i++){
                int nz=z+dz[i];
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nz>=0&&ny>=0&&nx>=0&&nz<H&&nx<N&&ny<M){
                    if(box[nz][nx][ny]==0){
                        box[nz][nx][ny]=1;
                        q.offer(new int[]{nz,nx,ny,days+1});
                    }
                }
            }

        }

    }
}