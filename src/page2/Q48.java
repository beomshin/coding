package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q48 {

    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int[] dz = {0, 1, 2};
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][M];
        int[][][] dp = new int[N+1][M][3];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int x=1; x <= N; x++) {
            for (int y=0; y < M; y++) {
                Arrays.fill(dp[x][y], 1000 * 100 + 1);
            }
        }

        for (int x=0; x <= N; x ++) {

            for (int y=0; y < M; y++) {

               for (int k=0; k < 3; k++) {
                   int x1 = x + dx[k];
                   int y1 = y + dy[k];
                   int z1 = dz[k];

                   if (check(x1, y1, z1)) {

                       int cost = table[x][y];

                       if (z1 == 0) {
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][1] + cost);
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][2] + cost);
                       } else if (z1 == 1) {
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][0] + cost);
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][2] + cost);
                       } else if (z1 == 2) {
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][0] + cost);
                           dp[x1][y1][z1] = Math.min(dp[x1][y1][z1], dp[x][y][1] + cost);
                       }

                   }
               }

            }

        }

        int min = Integer.MAX_VALUE;

            for (int y = 0; y < M; y++) {
                for (int z=0 ; z < 3; z++ ) {
                    min = Math.min(min, dp[N][y][z]);
                }
            }
        System.out.println(min);
    }

    public static boolean check(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x > N || y > M-1 || z > 2) return false;
        return true;
    }
}
