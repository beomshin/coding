package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q64 {

    static  ArrayList<Integer>[] tree;
    static int[] subTree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

         tree = new ArrayList[N+1];
         subTree = new int[N+1];

        for (int i=1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i=0; i < N-1; i ++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        dfs(R, new boolean[N+1]);


        for (int i=0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(subTree[n]);
        }
    }

    public static int dfs(int node, boolean[] visited) {

        int count = 1;
        visited[node] = true;

        for (int i=0; i < tree[node].size(); i++) {
            if (!visited[tree[node].get(i)]) {
                count += dfs(tree[node].get(i), visited);
            }
        }

        subTree[node] = count;
        return count;
    }
}
