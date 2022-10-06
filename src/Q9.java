import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9 {

    static int[][] table;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        table = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i=0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int x=0 ; x < N; x++) {
            for (int y=0; y < N; y++) {
                if (x == N-1 && y == N-1) break;
                else if (dp[x][y] > 0) {
                    int jump = table[x][y];
                    calculate(x + jump, y, dp, dp[x][y]);
                    calculate(x, y + jump, dp, dp[x][y]);
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }

    public static void calculate(int x, int y, long[][] dp, long num) {
        if (x > N-1 || y > N-1) return;

        dp[x][y] += num;
    }





}
