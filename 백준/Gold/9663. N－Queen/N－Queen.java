import java.util.Scanner;

public class Main {
    static int N;
    static boolean[]col;
    static boolean[]diag1;
    static boolean[]diag2;
    static int result=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        col=new boolean[N];
        diag1=new boolean[2*N];
        diag2=new boolean[2*N];
        dfs(0);
        System.out.println(result);

    }
    static void dfs(int x){
        if(x==N){
            result++;
            return;
        }
        for(int y=0;y<N;y++){
            if(!col[y]&&!diag1[x+y]&&!diag2[x-y+N-1]){
                col[y]=true;
                diag1[x+y]=true;
                diag2[x-y+N-1]=true;
                dfs(x+1);
                col[y]=false;
                diag1[x+y]=false;
                diag2[x-y+N-1]=false;
            }
        }
    }
}