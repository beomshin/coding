import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());

        for (int i=0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] table = new int[2][n];

            st = new StringTokenizer(br.readLine());

            for (int j=0; j < n; j++) {
                table[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int j=0; j < n; j++) {
                table[1][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][n];
            calculate(table, dp, n);
            int answer = Math.max(dp[0][n-1], dp[1][n-1]);

            System.out.println(answer);
        }

    }

    public static void calculate(int[][] table, int[][] dp, int size) {

        dp[0][0] = table[0][0];
        dp[1][0] = table[1][0];
        if (size == 1) return;
        dp[0][1] = Math.max(dp[0][0], table[1][0] + table[0][1]);
        dp[1][1] = Math.max(dp[1][0], table[1][1] + table[0][0]);

        for (int i=2; i < size; i++) {
            calculate2(table[0], dp[0], dp[1], i);
            calculate2(table[1], dp[1], dp[0], i);
        }

    }

    public static void calculate2(int[] table, int[] dp , int[] dp2 , int idx) {
        dp[idx] = Math.max(dp2[idx-1] + table[idx], dp2[idx-2] + table[idx]);
    }
}
