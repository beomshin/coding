import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q44 {

    static int MAX = 20;
    static int MIN = 0;
    static int[] d = {1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] table = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][21];

        dp[0][table[0]] = 1;

        for (int i=0; i < N - 2; i++) {

            for (int j=0; j <= 20; j++) {

                for (int k=0; k < 2; k++) {
                    int sum = j + (d[k] * table[i+1]);

                    if (sum >= MIN && sum <= MAX) {
                        dp[i+1][sum] += dp[i][j];
                    }

                }
            }
        }

        System.out.println(dp[N-2][table[N-1]]);
    }
}
