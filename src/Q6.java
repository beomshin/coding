import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q6 {

    static int[] W, S;
    static int N, max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = new int[N];
        S = new int[N];

        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            W[i] = w;
            S[i] = s;
        }

        calculate(0);

        System.out.println(max);
    }


    public static void calculate(int idx) {

        if (N == idx) {
            int count = 0;

            for (int i=0; i < N; i++) {
                if(S[i] <= 0) count++;
            }

            max = Math.max(max, count);
            return;
        }

        if (S[idx] < 0) {
            calculate(idx + 1);
        } else {

            int flag = 0;
            for (int i=0 ; i < N; i++) {
                if (i == idx) continue;
                else if(S[i] < 0) continue;

                S[i] -= W[idx];
                S[idx] -= W[i];

                calculate(idx + 1);

                S[i] += W[idx];
                S[idx] += W[i];
                flag = 1;
            }

            if(flag == 0) calculate(idx + 1);

        }

    }

}
