import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] moves;
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        moves = new int[101];
        visited = new boolean[101];
        for (int i = 1; i <= N + M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            moves[start] = end;
        }
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int pos = curr[0];
            int count = curr[1];
            if (pos == 100) {
                System.out.println(count);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = pos + i;

                if (next < 101) {
                    if (moves[next] != 0) {
                        next = moves[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(new int[]{next, count + 1});
                    }

                }
            }
        }
    }
}