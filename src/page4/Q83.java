package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q83 {

    static ArrayList<int[]>[] edge;
    static boolean[] leaf;
    static int N;
    static int answer = 0;

    /**
     * 트리의 지름
     * https://www.acmicpc.net/problem/1967
     *
     * 자식이 없는 leaf 에서 자식이 없는 leaf 간에 최대값을 구했다 (속도가 낮음 , 단순)
     *
     * 다른 방법 : 자식이 있는 노드에서 자식이 없는 leaf 까지의 최대값 두개를 합친 값 중에서 가장 큰값 구하기 (속도가 좋음 , 복잡)
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        edge = new ArrayList[N+1];
        leaf = new boolean[N+1];

        for (int i=1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }
        Arrays.fill(leaf, true);

        for (int i=0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int children = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            leaf[parent] = false;

            edge[parent].add(new int[]{children, cost});
            edge[children].add(new int[]{parent, cost});
        }

        for (int i=1; i <= N; i++) {
            if(leaf[i]) dfs(i, 0 , new boolean[N+1]);
        }

        System.out.println(answer);
    }

    public static void dfs(int no, int sum, boolean[] visited) {

        ArrayList<int[]> leaf = edge[no];
        visited[no] = true;

        for (int i=0; i < leaf.size(); i ++) {
            if (!visited[leaf.get(i)[0]]) {
                dfs(leaf.get(i)[0], sum + leaf.get(i)[1], visited);
            }
        }

        answer = Math.max(answer, sum);
    }
}
