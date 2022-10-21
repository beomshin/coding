package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q38 {

    static int N, K;
    static int[][] info;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        info = new int[N][2];

        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            info[i][0] = w;
            info[i][1] = v;
        }

        int[][] dp = new int[N+1][K+1];

        for (int i=1; i <= K; i++) {

            for (int j=1; j <= N; j++) {

                dp[j][i] = dp[j-1][i];
                int weight = info[j-1][0];
                int value = info[j-1][1];

                if (i - weight >= 0) {
                    dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i - weight] + value);
                }


            }

        }

        for (int i=0 ; i < dp.length; i ++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[N][K]);
    }
}
