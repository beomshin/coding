package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q63 {

    static int K, V;
    static ArrayList<int[]>[] table;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        table = new ArrayList[V+1];
        dp = new int[V+1];
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=0; i <= V; i++) table[i] = new ArrayList<>();

        for (int i=0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            table[u].add(new int[]{v, w});
        }


        bfs();

        for (int t=1; t <= V; t++) {
            System.out.println(dp[t] == Integer.MAX_VALUE ? "INF" : dp[t]);
        }

    }


    public static void bfs() {


        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        queue.add(new int[]{K, 0});

        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            int cur = node[0];
            int time = node[1];

            dp[cur] = Math.min(dp[cur], time);

            for (int i=0 ; i < table[cur].size(); i++) {
                int next = table[cur].get(i)[0];
                int cost = table[cur].get(i)[1];
                if (dp[next] > time + cost) {
                    queue.add(new int[]{next, time + cost});
                }
            }

        }

    }

}
