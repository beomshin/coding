package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q27 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] bee = new int[N];

        for (int i=0; i < N; i++) bee[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        int[][] dp = new int[2][N];
        dp[0][0] = bee[0];
        dp[1][0] = bee[N-1];
        for (int i=1; i < N; i++) {
            dp[0][i] = bee[i] + dp[0][i-1];
            dp[1][i] = bee[N-i-1] + dp[1][i-1];
        }

        int sum = dp[0][N-1];

        for (int i=1; i < N-1; i++) {
            max = Math.max(max, sum - bee[0] - bee[N-1] + bee[i]);
        }

        sum *= 2;
        for (int i=N-2; i > 0; i--) {
            max = Math.max(max, sum - dp[1][N-i-1] - bee[i] - bee[N-1]);
        }

        for (int i=1 ; i < N-1; i++) {
            max = Math.max(max, sum  - dp[0][i] - bee[i] - bee[0]);
        }
        System.out.println(max);
    }
}
