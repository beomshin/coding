package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q35 {

    static int  M, N;
    static int[][] table;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Queue<int[]> tomato = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (table[i][j] == 1) tomato.add(new int[]{i, j});
            }
        }

        int time = 0;
        while (!tomato.isEmpty()){

            ArrayList<int[]> list = new ArrayList<>();
            while (!tomato.isEmpty()) list.add(tomato.poll());

            for (int i=0 ; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                calculate(x, y);
            }

            time++;
        }

        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (table[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(time - 1);

    }

    public static void calculate(int x, int y) {


        for (int i=0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (check(x1, y1) && table[x1][y1] == 0) {
                   table[x1][y1] = 1;
                   tomato.add(new int[]{x1, y1});
            }
        }

    }


    public static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x > N-1 || y > M-1) return false;
        return true;
    }
}
