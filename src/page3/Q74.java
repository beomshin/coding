package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q74 {

    static int N, M;
    static int[][] table;
    static boolean[][] visited;

    static int[][] dx = {
            {0, 1},
            {0, -1},
            {0, -1},
            {0, 1}
    };

    static int[][] dy = {
            {-1, 0},
            {-1, 0},
            {1, 0},
            {1, 0}
    };

    static long answer = 0;

    /**
     * 무기 공학
     * https://www.acmicpc.net/problem/18430
     *
     * 백트래킹 문제로 해당 x,y 지점을 확인하며 4가지 부메랑 형태로 진행 가능시
     * 누적합을 채워간다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);

        System.out.println(answer);
    }

    public static void backtracking(int i, long sum) {

        int x = i / M;
        int y = i % M;

        if (N * M == i) {
            answer = Math.max(answer, sum);
            return;
        }

        if (visited[x][y]) {
            backtracking(i+1, sum);
        } else {

            for (int k=0; k < 4; k++) {
                int x1 = x + dx[k][0];
                int y1 = y + dy[k][0];
                int x2 = x + dx[k][1];
                int y2 = y + dy[k][1];

                if (check(x1, y1) && check(x2, y2)) {
                    visited[x][y] = true;
                    visited[x1][y1] = true;
                    visited[x2][y2] = true;
                    int num = (table[x][y] * 2) + table[x1][y1] + table[x2][y2];
                    backtracking(i+1, sum + num);
                    visited[x][y] = false;
                    visited[x1][y1] = false;
                    visited[x2][y2] = false;
                }
            }

            backtracking(i+1, sum);

        }

    }

    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > N-1 || y > M-1 || visited[x][y]) return false;
        return true;
    }


}
