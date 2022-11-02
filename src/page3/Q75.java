package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q75 {

    /**
     * 별 찍기 - 11
     * https://www.acmicpc.net/problem/2448
     *
     * 테이블로 첫 삼각형을 만들어주며
     * 이후 1 ... k단계마다 좌우로 현재까지 만들었던 테이블을 복사해준다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int num = N/3;
        int round = 0;
        while (num > 1) {
            round++;
            num /= 2;
        }

        int width = (int) (Math.pow(2, round) * 6 -1) + 1;
        int height = N;
        int mid = width/2 - 1;

        char[][] table = new char[height][width];

        for (int i=0; i < height; i++) Arrays.fill(table[i], ' ');

        table[0][mid] = '*';
        table[1][mid-1] = '*';
        table[1][mid+1] = '*';
        table[2][mid] = '*';
        table[2][mid-1] = '*';
        table[2][mid+1] = '*';
        table[2][mid-2] = '*';
        table[2][mid+2] = '*';

        int mul = 0;
        int stand = 3;

        for (int r=0; r < round; r++) {

            for (int h=stand; h < stand * 2 ; h++) {

                for (int i=0; i < mid; i++) {
                    table[h][i] = table[h - stand][i + (3 * (int)Math.pow(2, mul))];
                }

                for (int i= mid; i < width; i++) {
                    table[h][i] = table[h - stand][i - (3 * (int)Math.pow(2, mul))];
                }

            }

            stand *=2;
            mul++;
        }

        for (int i=0 ; i < height; i++) {
            System.out.println(new String(table[i]));
        }

    }
}
