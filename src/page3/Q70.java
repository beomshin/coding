package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q70 {

    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] table;
    static int N;

    /**
     * 숫자고르기
     * https://www.acmicpc.net/problem/2668
     *
     * 순환 구조값 찾아 저장
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        table = new int[N+1];

        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(st.nextToken());
        }


        for (int i=1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            dfs(i, visited, i);
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int n : answer) {
            System.out.println(n);
        }
    }


    public static void dfs(int idx, boolean[] visited, int root) {

        if (visited[idx]) {
            if (root == idx) {
                for (int i=1; i < visited.length; i++) {
                    if (visited[i] && !answer.contains(i)) {
                        answer.add(i);
                    }
                }
            }
            return;
        }

        visited[idx] = true;

        for (int i=1; i <= N; i++) {
            if (idx == table[i]) {
                dfs(i, visited, root);
            }
        }

        visited[idx] = false;

    }




}
