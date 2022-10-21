package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] table = new int[N];
        boolean[] canMove=  new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        canMove[0] = true;

        for (int i=0; i < N-1; i++) {

            if (canMove[i]) {

                for (int j=i+1; j < N; j++) {

                    int e = (j-i) * (1 + Math.abs(table[i] - table[j]));

                    if (e <= K) {
                        canMove[j] = true;
                    }

                }

            }

        }

        System.out.println(canMove[N-1] ? "YES" : "NO");
    }
}
