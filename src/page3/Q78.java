package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q78 {

    static int N, M;
    static int[][] table;
    static int[][] dp;

    /**
     * 끝나지 않는 파티
     * https://www.acmicpc.net/problem/11265
     *
     * 최단거리를 구하는 방식이다
     * 1. BFS를 통해 ROOT에서 이동하는 최단 거리를 DP로 저장하여 처리 (나의구현)
     * 2. 3중 for문을 통해 경로이동과 그냥 이동의 최소값을 만든다.
     *
     * 2가 효율적인 방안으로 2안으로 생각하는 방법이 필요
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate2();

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(table[A][B] <= C) {
                System.out.println("Enjoy other party");
            } else {
                System.out.println("Stay here");
            }
        }
    }

    public static void calculate() {

        for (int i=1; i <= N; i++) Arrays.fill(dp[i], 1000000);
        Queue<int[]> queue = new LinkedList<>();

        for (int i=1; i <= N; i++) {
            queue.add(new int[]{i, i, 0});
        }

        while (!queue.isEmpty()) {

            int[] val = queue.poll();
            int root = val[0];
            int loc = val[1];
            int cost = val[2];

            int[] edge = table[loc];

            for (int i=1; i < edge.length; i++) {
                if (loc ==i) continue;

                int time = table[loc][i];
                if (dp[root][i] > cost + time) {
                    dp[root][i] = cost + time;
                    queue.add(new int[]{root, i, cost + time});
                }
            }


        }

    }


    public static void calculate2() {

        for (int k=1; k <= N; k++) {
            for (int i=1; i <= N; i++) {
                for(int j=1; j <= N; j++) {
                    table[i][j] = Math.min(table[i][j], table[i][k] + table[k][j]);
                }
            }
        }

    }
}
