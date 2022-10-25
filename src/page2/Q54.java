package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q54 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] table = new int[N];

        for (int i=0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table);

        System.out.println(Arrays.toString(table));

        long answer = 0;
        for (int i=0; i < N; i++ ) {
            if (table[i] > 0) break;
            int pivot = table[i];

            int left = i + 1;
            int right = N - 1;

            while (left < right) {

                int sum = pivot + table[left] + table[right];

                if (sum == 0) {

                    int lc = 1;
                    int rc = 1;

                    if (table[left] == table[right]) {
                        int len = right - left + 1;
                        answer += len * (len-1) / 2;
                        break;
                    }


                    while (table[left] == table[left+1]) {
                        lc++;
                        left++;
                    }

                    while (table[right] == table[right-1]) {
                        rc++;
                        right--;
                    }

                    answer += rc * lc;
                }



                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }


        }

        System.out.println(answer);
    }
}
