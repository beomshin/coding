package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q68 {

    /**
     * 줄세우기
     * https://www.acmicpc.net/problem/2631
     *
     * LIS문제
     * 최장증가 부분 수열 찾기
     *
     * 이중 FOR문을 통하여 자신보다 작은 수의 DP값 MAX를 찾는다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] table = new int[N];

        for (int i=0;i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i=0; i < N; i++) {


            for (int j=0; j < i; j++) {

                if (table[j] < table[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }

        }

        System.out.println(Arrays.toString(dp));

        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(N - max);

    }

}
