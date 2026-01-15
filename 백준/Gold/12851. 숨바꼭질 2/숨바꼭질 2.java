import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[]dist;
    static int[]count;
    static int N;
    static int K;
    static final int max=100000;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        dist=new int[max+1];
        count=new int[max+1];
        Arrays.fill(dist,-1);
        bfs();
        System.out.println(dist[K]+ " " + count[K]);
    }
    static void bfs(){
        Queue<Integer>q=new LinkedList<>();
        q.offer(N);
        dist[N]=0;
        count[N]=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next:new int[]{curr-1,curr+1,curr*2}){
                if(next<max+1&&next>=0){
                    if(dist[next]==-1){
                        q.offer(next);
                        count[next]=count[curr];
                        dist[next]=dist[curr]+1;
                    }
                    //여러경우의 최단시간이 가능하므로
//                    next에 이미 도착한 적은 있는데, 지금 curr에서 한 칸 더 가도
//                    같은 최단 시간 으로 도착할 수 있다면, curr까지 오는 모든 최단 경로 수를
//                    next의 경로 수에 더해준다
                    else if(dist[next]==dist[curr]+1){
                        count[next]+=count[curr];
                    }
                }
            }
        }
    }
}