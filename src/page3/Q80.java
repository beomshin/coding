package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q80 {

    static int N, E;
    static int[][] graph;
    static int[] parents;

    /**
     * 최소 스패닝 트리
     * https://www.acmicpc.net/problem/1197
     *
     * 최소 스패닝 트리 알고리즘
     * 크루스칼 알고리즘
     *
     * 간선들의 가중치가 작은순으로 배열을 정리한후
     *
     * 간선들간에 사이클이 돌지않으면 합을 더하면 최소의 가중치 값이 나온다
     *
     * 사이클은 체크는 union find를 이용한 부모가 같으면 사이클 형성이 된다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[E][3];
        parents = new int[N+1];

        for (int i=1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i=0 ; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[i][0]= A;
            graph[i][1]= B;
            graph[i][2]= C;
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int sum = 0;
        for (int i=0; i < E; i++) {
            if (graph[i][0] > N || graph[i][1] > N) continue;

            if (getParent(graph[i][0]) != getParent(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                sum += graph[i][2];
            }
        }

        System.out.println(sum);
    }

    public static int getParent(int x) {
        if(parents[x] == x) return x;
        return parents[x] = getParent(parents[x]);
    }

    public static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        if (x!= y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
}
