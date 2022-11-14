package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q86 {

    static int answer = 0;

    /**
     * 회전 초밥
     * https://www.acmicpc.net/problem/15961
     *
     * 슬라이딩 윈도우 기법을 알아야한다
     *
     * 먼저 k개를 넣은후
     *
     * 앞 뒤로 하나씩 빼고 넣으면서
     *
     * 개수 1 경우 count를 증가시키고 0인경우 count를 내리며
     *
     * 최대값을 찾는 경우다
     *
     * 최대경우 c값이 0 이면 1을 증가시켜준다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] table = new int[N];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(st.nextToken());
        }

        int[] kind = new int[d+1];

        int count =0;

        for (int i=0; i < k; i++) {
            if (kind[ table[i]] == 0) count++;
            kind[table[i]]++;
        }

        answer = Math.max(answer, count);

        for (int i=0; i < N; i++) {

            if (answer <= count) {
                if (kind[c] == 0) answer = Math.max(answer, count + 1);
                else answer = Math.max(answer, count);
            }

            int insert = table[(i + k) % N];
            int delete = table[i];

            if (kind[delete] == 1) {
                count--;
            }
            kind[delete]--;

            if (kind[insert] == 0) {
                count++;
            }
            kind[insert]++;

        }

        System.out.println(answer);


    }
}
