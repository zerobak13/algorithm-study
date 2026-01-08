import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int[][]dp=new int[N][N];
        int[][] triangle=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                triangle[i][j]=sc.nextInt();
            }
        }
        dp[0][0]=triangle[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=triangle[i][j]+dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j]=triangle[i][j]+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int result=0;
        for(int j=0;j<N;j++) {
           result=Math.max(result,dp[N - 1][j]);
        }
        System.out.println(result);
    }
}
//[0][0]
//[1][0],[1][1]
//[2][0],[2][1],[2][2]