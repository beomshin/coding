package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q58 {

    static int N;
    static int[][] table;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        table = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        dfs(0);

        System.out.println(min);
    }


    public static void dfs(int idx) {


        if (idx == N) {
            calculate();
            return;
        }


        visited[idx] = true;
        dfs(idx + 1);
        visited[idx] = false;
        dfs(idx + 1);
    }

    public static void calculate() {

        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> blue = new ArrayList<>();

        for (int i=0; i < N; i ++) {
            if (visited[i]) red.add(i);
            else blue.add(i);
        }

        if (red.size() == 0 || blue.size() == 0) return ;

        int n = Math.abs(calculate(red, red.size()) - calculate(blue, blue.size()));

        min = Math.min(min, n);

    }

    public static int calculate(ArrayList<Integer> list, int size) {

        int sum = 0;

        for (int i=0 ; i < size; i++) {

            for (int j=i+1; j < size; j++) {
                int x = list.get(i);
                int y = list.get(j);

                sum += table[x][y] + table[y][x];

            }

        }

        return sum;

    }

}
