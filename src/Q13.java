import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q13 {

    static int d = 1000000000;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][10];

        for (int i=1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i=1 ; i < N; i++) {

            for (int j=0; j < 10 ; j++) {
                if (j==0) {
                    dp[i][j] = (dp[i-1][j+1]) % d;
                } else if(j== 9) {
                    dp[i][j] = (dp[i-1][j-1]) % d;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) %d;
                }
            }

        }

        int sum = Arrays.stream(dp[N-1]).sum()  % d;
        System.out.println(sum);
    }


}
