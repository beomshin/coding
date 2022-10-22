package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q46 {

    static int T, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        int[][] coin = new int[K][2];
        ArrayList<Integer> list = new ArrayList<>();


        for (int i=0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            coin[i][0] = p;
            coin[i][1] = n;
        }

        int[] dp = new int[T+1];
        dp[0] = 1;

        for (int i=0; i < K; i++) {

            int p = coin[i][0];
            int n = coin[i][1];

            Stack<int[]> stack = new Stack<>();

            for (int j=0; j < n; j++) {
                int cost = p * (j+1);

                for (int k=0; k <= T; k++) {
                    if (k - cost >= 0) {
                        stack.add(new int[]{k, dp[k-cost]});
                    }
                }

            }

            while (!stack.isEmpty()) {
                int[] s = stack.pop();
                dp[s[0]] = Math.max(dp[s[0]], dp[s[0]] + s[1]);
            }

        }

        System.out.println(dp[T]);
    }

}
