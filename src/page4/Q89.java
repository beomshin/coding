package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q89 {

    static int R, C, T;
    static int[][] table;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<int[]> line = new ArrayList<>();
    static int answer = 0;

    /**
     * 미세먼지 안녕!
     * https://www.acmicpc.net/problem/17144
     *
     * 구현 과정이 길어서 시간이 좀 걸린다
     *
     * 두 가지 경우로 생각해서 풀어야한다
     * 미세먼지 확산
     * 미세먼지 청소
     *
     * 확산은 동시에 모든 지역에서 일어나는게 키워드다
     * 청소는 값을 옮기면 된다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        table = new int[R][C];

        for (int i=0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < C; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if(table[i][j] == -1) line.add(new int[]{i, j});
            }
        }

        while (T> 0) {
            diffusion();
            clear();
            T--;
        }

        for (int i=0; i < R; i++ ) {
            answer += Arrays.stream(table[i]).sum();
        }

        System.out.println(answer + 2);
    }

    public static void diffusion() {

        int[][] sums = new int[R][C];
        ArrayList<Integer> list =  new ArrayList<>();

        for (int i=0; i < R; i++) {
            for (int j=0; j < C; j++) {
                if (table[i][j] == -1 || table[i][j] ==0) continue;

                for (int k=0; k < 4; k++) {
                    if (check(i + dx[k], j + dy[k])) list.add(k);
                }

                if (list.size() > 0) {
                    for (int l=0; l < list.size(); l++) {
                        sums[i + dx[list.get(l)]][j + dy[list.get(l)]] += table[i][j]/5;
                    }
                    sums[i][j] += table[i][j] - (table[i][j]/5) * list.size();
                }
                list.clear();
            }
        }

        table = sums;
        table[line.get(0)[0]][line.get(0)[1]] = -1;
        table[line.get(1)[0]][line.get(1)[1]] = -1;

    }

    public static void clear() {
        clear1(line.get(0)[0]);
        clear2(line.get(1)[0]);
    }

    public static void clear1(int x) {

        for (int i=x-1; i > 0; i--) {
            table[i][0] = table[i-1][0];
        }

        for (int i=0; i < C-1; i++) {
            table[0][i] = table[0][i+1];
        }

        for (int i=0; i < x ; i++) {
            table[i][C-1] = table[i+1][C-1];
        }

        for (int i=C-1; i > 0; i--) {
            table[x][i] = table[x][i-1];
        }

        table[x][1] = 0;

    }

    public static void clear2(int x) {

        for (int i=x+1; i < R-1; i++) {
            table[i][0] = table[i+1][0];
        }

        for (int i=0; i < C-1; i++) {
            table[R-1][i] = table[R-1][i+1];
        }

        for (int i=R-1; i > x; i--) {
            table[i][C-1] = table[i-1][C-1];
        }

        for (int i=C-1; i > 0; i--) {
            table[x][i] = table[x][i-1];
        }

        table[x][1] = 0;
    }


    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > R-1 || y > C-1 || table[x][y] == -1) return false;
        return true;
    }

}
