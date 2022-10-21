package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q37 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i=0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            calculate(coin, M, N);
        }


    }

    public static void calculate(int[] coin, int target, int N) {

        long[] dp = new long[target+1];

       dp[0] = 1;

        for (int i=0 ; i < N; i++) {
            int cost = coin[i];

            for (int j=0; j <= target; j++) {
                if (j >= cost) {
                    dp[j] += dp[j - cost];
                }
            }

        }

        System.out.println(dp[target]);
    }
}
