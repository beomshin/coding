import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29 {

    static int N, M;
    static int[] coin;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coin = new int[N];
        int[] dp = new int[M+1];

        Arrays.fill(dp, 10001);

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
            if (coin[i] <= M) {
                dp[coin[i]] = 1;
            }
        }

        for (int i=1; i <= M; i++) {

            for (int j=1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }

        }

        System.out.println(dp[M] == 10001 ? -1 : dp[M]);
    }
}
