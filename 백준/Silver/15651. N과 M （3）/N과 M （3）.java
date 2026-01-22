import java.util.*;
public class Main {
    static int[]num;
    static int N;
    static int M;
    static int[]result;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        num=new int[N];
        for(int i=1;i<=N;i++){
            num[i-1]=i;
        }
        result=new int[M];
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth){
        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(result[i]+" ");

            }
            sb.append('\n');
            return;

        }
            for(int i=0;i<N;i++) {
                result[depth] = num[i];
                dfs(depth + 1);
//                result = new int[M];
            }
        }


}