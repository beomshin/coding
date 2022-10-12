import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q28 {

    static int N, M;
    static int[] coin;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coin = new int[N];
        int[] dp = new int[M+1];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }


        dp[0] = 1;
        for (int i=0; i < N; i++) {
            int c = coin[i];

            for (int j=1; j <= M;j++) {
                if (j - c >= 0) {
                    dp[j] = dp[j] + dp[j - c];
                }

            }

        }


        System.out.println(dp[M]);

    }
}
