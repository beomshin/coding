package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q43 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];

        Arrays.fill(dp[1], 1);

        for (int i=1 ; i < K; i++) {

            for (int j=0; j <= N; j++) {

                for (int k=0; k <=N; k++) {

                    int sum = j+k;

                    if (sum <= N) {
                        dp[i+1][sum] = (dp[i+1][sum] + dp[i][j]) % 1000000000;
                    }

                }

            }

        }

        System.out.println(dp[K][N]);
    }
}
