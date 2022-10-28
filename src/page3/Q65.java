package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q65 {

    static int N, M;
    static int[][] table;
    static long answer = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];


        for (int i=0; i < N; i++) {
            String num = br.readLine();

            for (int j=0; j < num.length(); j++) {
                table[i][j] = num.charAt(j) - '0';
            }

        }

        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                calculate(i, j);
            }
        }

        System.out.println(answer);
    }


    public static void calculate(int x, int y) {

        check2(table[x][y]);

        for (int i= N * -1 + 1; i < N; i++) {

            for (int j= M *-1 + 1; j < M; j++ ) {
                if(i==0 && j==0) continue;
                dfs(x, y, i, j, 0);
            }

        }

    }


    public static void dfs(int x, int y, int dx, int dy, long num) {

        if (!check(x, y)) {

            if (num != 0) {
                check2(num);
            }

            return;
        }

        if (num != 0) {
            check2(num);
        }

        dfs(x + dx , y + dy, dx, dy, num * 10 + table[x][y]);

    }


    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > N-1 || y > M-1) return false;
        return true;
    }

    public static void check2(long num) {
        double n1 = Math.sqrt(num);

        if (n1 == (int)n1) {
            answer = Math.max(answer, num);
        }
    }

}
