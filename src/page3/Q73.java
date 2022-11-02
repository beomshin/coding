package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q73 {

    /**
     * 색종이와 가위
     * https://www.acmicpc.net/problem/20444
     *
     * 자른 종이 개수는 (가로 자른 횟수 +1) * (세로 자른 횟수 +1)
     * 가장 높은 값은 자른 횟수가 같은경우로 최대값은 중간 값으로 만들어
     * 이분 탐색을한다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n/2 + 1;


        while (left <= right) {

            long mid = (left + right) / 2;

            long n1 = (mid + 1);
            long n2 = (n - mid + 1);

            long num = n1 * n2;

            if (num == k) {
                System.out.println("YES");
                return;
            } else if (num < k) {
                left = mid+1;
            } else if (num > k) {
                right = mid-1;
            }

        }

        System.out.println("NO");

    }
}
