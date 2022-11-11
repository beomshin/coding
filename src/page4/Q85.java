package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q85 {

    static int N, M;
    static int[][] dp;
    static int[] sum;

    /**
     * 구간 나누기
     * https://www.acmicpc.net/problem/2228
     *
     * 개어렵다..
     *
     *
     * 점화식 생각 방법이 너무 어렵다
     *
     * 일단 DP [N][M]으로 만들어준다
     *
     * 생각해봐야하는건
     *
     * 현재 수가 구간 경우 최대값을 누적해 나간다
     *
     * 현재 구간 최대값 = MAX(이전 수 구간 값, 현재 수가 새로운 구간단계일경우 최대값)
     *
     * 복잡하다..
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] table = new int[N+1];
        sum = new int[N+1];

        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+table[i];
        }

        dp = new int[N+1][M+1];

        for(int i=0; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = -32768*101;
            }
        }

        dp[1][1] = table[1];
        for (int i=2; i <= N; i++) {

            for (int j=1; j <= M; j++) {

                dp[i][j] = dp[i-1][j];
                if (j==1) dp[i][j] = Math.max(dp[i][j], sum[i]);

                for (int k=i-2; k >=0 ; k--) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + sum[i] + (sum[k+1] * -1));
                }
            }

        }

        for (int i=0; i <= N;i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[N][M]);
    }


}
