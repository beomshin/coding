package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q72 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, L, R;
    static boolean stop = false;

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] table;

    /**
     * 인구 이동
     *
     * https://www.acmicpc.net/problem/16234
     *
     * 변화를 감지하여 해당 지역에 인구이동이가능시 bfs 작업 수행
     * 인구 이동을 한후 다시 변화 감지
     * 변화가 없는경우 해당 인구 이동이 종료날
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        table = new int[N][N];

        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                table[i][j] = num;
            }
        }

        int day = 0 ;

        while (true) {
            if (calculate()) break;
            day++;
        }

        System.out.println(day);
    }

    public static boolean calculate() {

        boolean[][] visited = new boolean[N][N];
        boolean flag = true;

        for (int i=0; i < N; i++) {

            for (int j=0; j < N; j++) {

                if (!visited[i][j]) {

                    for (int k=0; k < 4; k ++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (check(x, y) && check2(i, j, x, y)) {
                            flag = false;
                            bfs(i, j, visited);
                            break;
                        }
                    }


                }

            }

        }

        return flag;


    }

    public static void bfs(int sx, int sy, boolean[][] visited) {

        ArrayList<Node> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList();

        queue.add(new int[]{sx, sy});

        while (!queue.isEmpty()) {

            int[] n = queue.poll();
            int x = n[0];
            int y = n[1];

            if (visited[x][y]) continue;
            list.add(new Node(x, y));
            visited[x][y] = true;

            for (int i=0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                if (check(x1, y1) && check2(x, y, x1, y1)) {
                    queue.add(new int[]{x1, y1});
                }
            }
        }

        int sum = 0;
        for (int i=0; i < list.size(); i++) {
            sum += table[list.get(i).x][list.get(i).y];
        }
        sum /= list.size();
        for (int i=0; i < list.size(); i++) {
            table[list.get(i).x][list.get(i).y] = sum;
        }

    }

    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > N-1 || y > N-1) return false;
        return true;
    }

    public static boolean check2(int x1, int y1, int x2, int y2) {
        int num1 = table[x1][y1];
        int num2 = table[x2][y2];
        int minus = Math.abs(num1 - num2);
        if (minus >= L && minus <= R) return true;
        return false;
    }
}
