import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q19 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] people = new int[N];
        int[] dp = new int[C+1];

        Arrays.fill(dp, 1000*100+1);

        for (int i=0; i < N; i++ ){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            cost[i] = c;
            people[i] = p;

            if(p > dp.length-1) {
                p = dp.length-1;
            }
            dp[p] = Math.min(dp[p], c);
        }

        dp[0] = 0;

        for (int i=1; i <= C; i++) {
            for (int j=1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }

        for(int i=1; i < C; i++) {
            for(int j=1; j < C; j++) {
                if(i + j >= C) {
                    dp[C] = Math.min(dp[i] + dp[j], dp[C]);
                }
            }
        }

        System.out.println(dp[C]);
    }
}
