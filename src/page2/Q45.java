package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q45 {

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0 ,-1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int[][][] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i < N * H; i++) {

            int h = i/N ;
            int n = i%N ;

            st = new StringTokenizer(br.readLine());

            for (int j=0; j < M ; j++) {
                box[n][j][h] = Integer.parseInt(st.nextToken());
                if(box[n][j][h] == 1) {
                    queue.add(new int[]{n, j, h});
                }
            }

        }

        while (!queue.isEmpty()) {

            int[] tomato = queue.poll();


            for (int i =0; i < 6 ; i++) {
                int x = tomato[0] + dx[i];
                int y = tomato[1] + dy[i];
                int z = tomato[2] + dz[i];

                if(check(x, y, z)) {

                    queue.add(new int[]{x, y, z});
                    box[x][y][z] = box[tomato[0]][tomato[1]][tomato[2]] + 1;

                }

            }


        }

        int result = Integer.MIN_VALUE;

        for (int x=0; x < N; x++) {

            for (int y=0; y < M; y++) {

                for (int z=0; z < H; z++) {
                    if (box[x][y][z] == 0){
                        System.out.println(-1);
                        return;
                    }

                    result = Math.max(result, box[x][y][z]);
                }

            }

        }

        if (result == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(result - 1);
    }

    public static boolean check(int x, int y, int z) {
        if (x < 0 || y < 0|| z < 0 || x > N-1 || y > M-1 || z > H-1 || box[x][y][z] != 0) return false;
        return true;
    }


}
