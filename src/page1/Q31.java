package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q31 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] solution = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) solution[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(solution);

        int left = 0;
        int right = N-1;
        long answer = Long.MAX_VALUE;
        int l = left;
        int r = right;

        while (left < right) {

            long min = solution[left] + solution[right];

            if (Math.abs(min) < answer) {
                answer = Math.abs(min);
                l = left;
                r = right;
            }

            if (min >= 0) {
                right--;
            } else {
                left++;
            }

        }


        System.out.println(solution[l] + " " + solution[r]);


    }
}

