package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t;
            P[i] = p;
        }

        int[] dp = new int[N+1];
        int mul = 0;

        for (int i=0; i < N; i++) {

            int cost = P[i];
            int next = i + T[i];
            mul = Math.max(mul, dp[i]);
            dp[i] = mul;

            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + cost);
            }

        }

        System.out.println(Math.max(dp[N], dp[N-1]));
    }
}
