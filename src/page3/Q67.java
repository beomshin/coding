package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q67 {

    /**
     * 가장 큰 정사각형
     * https://www.acmicpc.net/problem/1915
     *
     * 배열 중 가장 큰 정사각형을 찾는다
     *
     * dp로 해당 좌표에 위 아래 대각선 아래 중 가장 작은 값을 누적한다
     *
     * 쌓인 dp내에서 가장큰 값이 가장 큰 정사각형 길이이다.
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] table = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            for (int j=1; j <= M; j++) {
                table[i][j] = word.charAt(j-1) - '0';
            }
        }

        for (int x=1; x <= N; x++) {
            for (int y=1; y <= M; y++) {
                if (table[x][y] == 1) {

                    int min = Math.min(dp[x-1][y], dp[x][y-1]);
                    min = Math.min(min, dp[x-1][y-1]);
                    dp[x][y] = min + 1;

                }
            }
        }

        int max = 0;
        for (int i=0; i <= N; i++) {
            for(int j=0; j <= M; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max * max);
    }
}
