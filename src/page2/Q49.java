package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q49 {

    static int W,H;
    static int[][] table;

    static int[][][] d = {
            {{-1, -1}, {0, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, 0}},
            {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 0}}
    };

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        table = new int[W+1][H+1];

        for (int y=1; y <= H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=1; x <= W; x++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y=1; y <= H; y++) {
            for (int x=1; x <= W; x++) {
                if (table[x][y] == 0 && !calculate(y, x, new boolean[W+1][H+1])) {
                    table[x][y] = 1;
                }
            }
        }

        int answer = 0;
        visited = new boolean[W+1][H+1];
        for (int y=1; y <= H; y++) {
            for (int x=1; x <= W; x++) {
                if (!visited[x][y]) {
                    answer += calculate2(x, y);
                }
            }
        }

        System.out.println(answer);

    }

    public static boolean calculate(int y, int x, boolean[][] visited) {
        if (y < 1 || x < 1 || y > H || x > W ) return true;
        else if(visited[x][y] || table[x][y] == 1) return false;

        visited[x][y] = true;

        int[][] r = y % 2 == 0 ? d[0] : d[1];

        for (int i=0; i < 6 ; i++) {
            int dx = r[i][0];
            int dy = r[i][1];

            if(calculate(y + dy, x +dx, visited)) {
                return true;
            }
        }

        return false;
    }

    public static int calculate2(int x, int y) {
        if (!check(x,y) ||table[x][y] == 0 || visited[x][y]) return 0;

        visited[x][y] = true;

        int[][] r = y % 2 == 0 ? d[0] : d[1];

        int count = 0;
        for (int i=0 ; i < 6 ; i++) {
            int dx = r[i][0] + x;
            int dy = r[i][1] + y;

            count += calculate2(dx, dy);
            if (!check(dx, dy) || table[dx][dy] == 0) count += 1;

        }

        return count;
    }

    public static boolean check(int x, int y) {
        if (x < 1 || y < 1 || x > W || y > H) return false;
        return true;
    }



}
