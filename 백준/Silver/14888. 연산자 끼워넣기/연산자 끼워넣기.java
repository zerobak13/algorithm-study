import java.util.*;
public class Main {
    static int[]num;
    static int N;
    static int[]oper;
    static int max_result=Integer.MIN_VALUE;
    static int min_result=Integer.MAX_VALUE;
    static int result;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=sc.nextInt();
        }
        oper=new int[4];
        for(int i=0;i<4;i++){
            oper[i]=sc.nextInt();
        }

        dfs(num[0],1);
        System.out.println(max_result+" "+min_result);

    }
    static void dfs(int result, int index){
        if(index==N){
            max_result=Math.max(max_result,result);
            min_result=Math.min(min_result,result);
            return;
        }
        for(int i=0;i<4;i++){
            if(oper[i]>0) {
                oper[i]--;
                if (i == 0) {
                    dfs(result + num[index], index + 1);
                    oper[i]++;

                } else if (i == 1) {
                    dfs(result - num[index], index + 1);
                    oper[i]++;

                } else if (i == 2) {
                    dfs(result * num[index], index + 1);
                    oper[i]++;

                } else if (i == 3) {
                    dfs(result / num[index], index + 1);
                    oper[i]++;

                }
            }

        }

    }
}