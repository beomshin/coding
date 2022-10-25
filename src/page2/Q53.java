package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Q53 {

    static int[][] dp;
    static int N, M, H;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        dp = new int[N+1][H+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list[i] = new ArrayList<>();
            while (true) {
                try {
                    int num = Integer.valueOf(st.nextToken());
                    list[i].add(num);
                } catch (NoSuchElementException e) {
                    break;
                }
            }
        }

       for (int i=0; i < N; i++) dp[i][0] = 1;

        for (int i=1; i <= N ; i++) {

            for (int j=1; j <= H; j++ ){

                ArrayList<Integer> nums = list[i-1];

                for (int num : nums) {
                    if (j >= num) {
                        dp[i][j] += dp[i-1][j-num] %= 10007;
                    }
                }

                dp[i][j] += dp[i-1][j] %= 10007;
            }
        }

        System.out.println(dp[N][H]% 10007);
    }


}
