package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q90 {

    /**
     * 공유기 설치
     * https://www.acmicpc.net/problem/2110
     *
     * 공유기 최대 설치 길이를 구하여 이분 탐색을 통하여
     * 길이 별 설치 가능 공유기 대수를 구하여 최대 값을 구한다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] table = new int[N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table);

        int total = table[N-1] - table[0];
        int left = 0;
        int right = total;
        int answer = 0;


        while (left <= right) {

            int mid = (right + left) / 2;

            if (check(table, mid) >= C) { // 길이 ok
                answer = Math.max(answer, mid);
                left = mid+1;
            } else { // 길이가 큼
                right = mid-1;
            }


        }

        System.out.println(answer);

    }

    public static int check(int[] table, int len) {

        int cur = 0;
        int next = 1;
        int count = 1;

        while (next < table.length) {

            if (table[next] - table[cur] >= len) {
                cur = next;
                count++;
            }

            next++;
        }

        return count;
    }
}
