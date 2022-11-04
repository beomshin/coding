package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q79 {

    static int[] group;

    /**
     * 집합의 표현
     * https://www.acmicpc.net/problem/1717
     *
     * union find 문제이다
     *
     * 해당 문제를 통해 union find를 익혔다
     *
     * 보통 작은 순위를 나의 parent로 두며 이를 해결해나간다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        group = new int[N+1];
        for (int i=0; i <= N; i++) {
            group[i] = i;
        }

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(a, b);
            } else if (type == 1) {
                sb.append((isUnion(a, b) ? "YES" : "NO") + "\n");
            }

        }

        System.out.println(sb.toString());

    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                group[x] = y;
            } else {
                group[y] = x;
            }
        }
    }

    public static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x==y) return true;
        return false;
    }

    public static int find(int n) {
        if(group[n] == n) return n;
        return group[n] = find(group[n]);
    }
}
