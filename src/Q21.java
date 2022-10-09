import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q21 {

    static ArrayList<Integer>[] graph;
    static int[][] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        answer = new int[N][N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = new ArrayList<>();
            for (int j=0; j< N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i=0; i < N; i++) {
            calculate(i, i, new boolean[N]);
        }

        for (int i=0 ; i < N; i++) {
            for (int j=0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void calculate(int start, int n, boolean[] visited) {

        for (int i=0; i < graph[n].size(); i++) {
            int g = graph[n].get(i);
            if (!visited[g]) {
                answer[start][g] = 1;
                visited[g] = true;
                calculate(start, g, visited);
            }
        }


    }
}
