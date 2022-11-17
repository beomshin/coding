package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q88 {

    static int[][] dx = {
            {0, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 1, 2, 2},
            {0, 1, 1, 2},
            {0, 0, 1, 0}
    };


    static int[][] dy = {
            {0, 1, 2, 3},
            {0, 1, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 1, 1},
            {0, 1, 1, 2}
    };


    static int N, M;
    static int[][] table;


    /**
     * 테트로미노
     *
     * https://www.acmicpc.net/problem/14500
     *
     * 테트리스 case 5개 케이스를 회전 , 반전 시키면 검사한다.
     *
     * 회전 케이스를 찾기 약간 까다로웠다
     *
     * y- > x , x-> y가 되며 y * -1 회전 케이스다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int n=0; n < 5; n++) {

            for (int i=0; i < N; i++) {
                for (int j=0; j < M; j++) {
                    answer = Math.max(answer, calculate(i,j, n));
                }
            }

        }

        System.out.println(answer);

    }


    public static int calculate(int x, int y, int n) {

        int max = 0;

        for (int i=0; i < 4 ; i++) {

            int[][] square = new int[4][2];

            for (int j=0; j < 4; j++) {
                square[j][0] = x + dx[n][j];
                square[j][1] = y + dy[n][j];
            }

            if (check(square)) {
                max = Math.max(max, sum(square));
            }

            for (int j=0; j < 4; j++) {
                square[j][0] = x + (dx[n][j] * -1);
                square[j][1] = y + dy[n][j];
            }

            if (check(square)) {
                max = Math.max(max, sum(square));
            }

            for (int k=0; k < 4; k++) {
                int temp = dx[n][k];
                dx[n][k] = dy[n][k];
                dy[n][k] = temp;
                dy[n][k] *= -1;
            }

        }



        return max;
    }


    public static boolean check(int[][] square) {

        for (int i=0; i < 4; i++) {
            if(square[i][0] < 0 ||  square[i][0] > N-1 || square[i][1] < 0 || square[i][1] > M-1) {
                return false;
            }
        }

        return true;
    }

    public static int sum(int[][] square) {

        int sum = 0;

        for (int i=0; i <4; i++) {
            int x = square[i][0];
            int y = square[i][1];
            sum += table[x][y];
        }

        return sum;
    }

    public static void rotate(int[][] square) {



    }


}
