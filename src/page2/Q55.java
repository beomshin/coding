package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q55 {

    static int N, M, T;
    static int[][] table;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;
    static boolean[][] visited;
    static int flag = 0;
    static class Node {
        int x, y, time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        int s1 = 0;
        int s2 = 0;
        for (int i=0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE );

        for (int i=0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (table[i][j] == 2) {
                    s1 = i;
                    s2 = j;
                }
            }

        }

        calculate(0, 0, 0, 0);
        if (flag == 1) {
            calculate(s1, s2, dp[s1][s2], flag);
        }

        System.out.println(dp[N-1][M-1] > T ? "Fail" : dp[N-1][M-1]);
    }

    public static void calculate(int start, int end, int time ,int type) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, end, time));
        boolean on = false;

        while (!queue.isEmpty()) {

            Node info = queue.poll();
            int x = info.x;
            int y = info.y;
            int t = info.time;

            if (T < t) continue;;

            visited[x][y] = true;
            dp[x][y] = Math.min(dp[x][y], t);

            if (table[x][y] == 2) on = true;

            for (int k=0; k < 4; k++) {
                int x1 = x + dx[k];
                int y1 = y + dy[k];

                if (check(x1, y1) && (!visited[x1][y1] || dp[x1][y1] >= t+1)) {
                    if (type == 1) {
                        queue.add(new Node(x1, y1, t+1));
                    } else {
                        if(table[x1][y1] == 0 || table[x1][y1] == 2) {
                            queue.add(new Node(x1, y1, t+1));
                        }
                    }
                }
            }

        }

        if (on) flag = 1;

    }

    public static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x > N-1 || y > M-1) return false;
        return true;
    }
}
