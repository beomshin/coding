package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q87 {

    static ArrayList<Integer>[] table;
    static boolean[] visited;
    static boolean flag = false;

    /**
     * ABCDE
     * https://www.acmicpc.net/problem/13023
     *
     * 간단한 dfs, 트리문제
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        table = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0; i < N; i ++) table[i] = new ArrayList<>();

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            table[n1].add(n2);
            table[n2].add(n1);
        }

        for (int i=0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(flag ? 1 : 0);
    }

    public static void dfs(int no, int count) {
        if (flag) return;
        else if (count == 5) flag = true;
        for (int i=0; i < table[no].size(); i++) {
            int num = table[no].get(i);
            if (!visited[num]) {
                visited[num] = true;
                dfs(num, count+1);
                visited[num] = false;
            }
        }
    }

}
