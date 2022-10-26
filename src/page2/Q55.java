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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        table = new int[N][M];

        int s1 = 0;
        int s2 = 0;

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

        int min = calculate(0, 0, N-1, M-1, 0);
        min = Math.min(min, calculate(0, 0, s1, s2, 0) + calculate(s1, s2, N-1, M-1, 1));

        System.out.println(min > T ? "Fail" : min);
    }

    public static int calculate(int sx, int sy, int tx, int ty, int type) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        boolean[][] visited = new boolean[N][M];
        int min = T+1;

        while (!queue.isEmpty()) {

            int[] data = queue.poll();
            int x = data[0];
            int y = data[1];
            int t = data[2];

            if (!check(x,y, visited) || (type == 0 && table[x][y] == 1)) continue;
            else if(x == tx && y == ty) {
                min = Math.min(min, t);
                continue;
            }

            visited[x][y] = true;

            for (int k=0; k < 4; k++) {
                int x1 = x + dx[k];
                int y1 = y + dy[k];
                queue.add(new int[]{x1, y1, t + 1});
            }
        }

        return min;
    }

    public static boolean check(int x, int y, boolean[][] visited) {
        if(x < 0 || y < 0 || x > N-1 || y > M-1 || visited[x][y] ) return false;
        return true;
    }
}
