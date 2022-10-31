package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q69 {

    /**
     * 가장 긴 짝수 연속한 부분 수열 (large) 성공
     *
     * https://www.acmicpc.net/problem/22862
     *
     * 투포인터 문제
     *
     * 해당 홀수 개수를 유지하며 left , right 거리를 계산해준다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] table = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        int mul = 0;
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < N) {


            if (mul > K) {

                if (table[left] %2 != 0) mul--;

                left++;

                continue;
            }

            if (table[right]%2 == 0) {
                max = Math.max(max, right - left - mul + 1);
            } else {
                mul++;
            }

            right++;
        }

        System.out.println(max);

    }
}
