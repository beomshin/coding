package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q59 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] gate = new long[N];
        long max = 0;

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gate[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, gate[i]);
        }

        long left = 1;
        long right = max * M;
        long answer = max * M;

        while (left <= right) {

            long mid = (left + right) / 2;

            long count = 0;
            for (int i=0; i < N; i++) {
                count += mid/gate[i];
            }

            if (count >= M) {
                answer = Math.min(answer, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        System.out.println(answer);
    }
}
