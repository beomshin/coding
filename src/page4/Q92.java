package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q92 {

    /**
     * 점수따먹기
     * https://www.acmicpc.net/problem/1749
     *
     * 부분 행렬 구하는 누적합
     *
     * 누적합 예는 일단 총합 테이블을 만들고
     *
     * 4중 for문으로 지역값을 구하면 된다.
     *
     * 처음에는 모든 면이 끝까지 다야하는줄 알고 구했다
     * 추가적으로 최소값이 0이하로 될수 있다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][M+1];

        for (int i=1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j=1; j  <= M ; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] sum = new long[N+1][M+1];

        for (int i=1; i <= N; i++) {
            for (int j=1; j <= M; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + table[i][j] - sum[i-1][j-1];
            }
        }

        long answer = Long.MIN_VALUE;

        for (int i=0; i <= N; i++) {
            for (int j=0; j <= M; j++) {

                for (int x=i+1; x <= N; x++) {
                    for (int y=j+1; y <= M; y++) {
                        answer = Math.max(answer, sum[x][y] - sum[i][y] - sum[x][j] + sum[i][j]);
                    }
                }


            }
        }

        System.out.println(answer);
    }
}
