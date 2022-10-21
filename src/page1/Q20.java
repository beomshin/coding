package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q20 {

    static int N;
    static int[] table;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        table = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1 || N == 2) {
            System.out.println(N);
            return;
        }

        int max = 0;
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                if(i == j) continue;
                int count = 2;

                for (int k=0; k < N; k++) {
                    if(i == k || j == k) continue;
                    if(check(table[i], table[j], table[k])) count++;
                }
                max = Math.max(max, count);
            }

        }

        System.out.println(max);

    }

    public static boolean check(int x, int y, int z) {
        if (x + y > z && z >= Math.max(x, y)) return true;
        return false;
    }
}
