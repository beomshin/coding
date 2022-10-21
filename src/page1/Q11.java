package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] grapes = new int[N];
        int[] dp1 = new int[N]; // 안먹는경우 최대
        int[] dp2 = new int[N]; // 첫번째인경우 최대
        int[] dp3 = new int[N]; // 마지막인경우 최대

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            grapes[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1) {
            System.out.println(grapes[0]);
            return;
        } else {
            dp1[0] = 0;
            dp1[1] = grapes[0];
            dp2[0] = grapes[0];
            dp2[1] = grapes[1];
            dp3[0] = grapes[0];
            dp3[1] = grapes[0] + grapes[1];
        }

        for (int i=2 ; i < N; i++) {
            dp1[i] = Math.max(dp2[i-1] , dp3[i-1]);
            dp1[i] = Math.max(dp1[i], dp1[i-1]);
            dp2[i] = Math.max(dp1[i-1], dp3[i-2]) + grapes[i];
            dp3[i] = dp2[i-1] + grapes[i];

        }

        int max = Math.max(dp1[N-1], dp2[N-1]);
        max = Math.max(max, dp3[N-1]);
        System.out.println(max);
    }
}
