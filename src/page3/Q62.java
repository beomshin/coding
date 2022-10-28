package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q62 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] table = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i <= N; i++) table[i] = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];

        int mul = 0;
        for (int i=1; i <= N; i++) {
            if (table[i] < table[i-1]) mul++;
            dp[i] = mul;
        }

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            System.out.println(dp[n2] - dp[n1]);

        }

    }
}
