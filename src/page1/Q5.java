package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Q5 {

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[][] table = new int[19][19];
    static int ROW = 19;
    static int win = 0;
    static int mx = Integer.MAX_VALUE;
    static int my = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i < ROW; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < ROW; j++) table[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int x=0; x < ROW; x++) {
            for (int y=0; y < ROW; y++) {
                if (table[x][y] != 0) {

                    for (int i=0 ; i < 8 ; i++) {

                        int size = calculate(table[x][y], x, y, dx[i], dy[i], 0) + calculate(table[x][y], x, y, dx[i] *- 1, dy[i] * -1, 0) - 1;
                        if (size == 5 ) {
                            if(my > y) {
                                win = table[x][y];
                                mx = x;
                                my = y;
                            } else if(my == y && mx > x) {
                                win = table[x][y];
                                mx = x;
                                my = y;
                            }
                        }


                    }

                }
            }
        }

        if (win == 0) {
            System.out.println(win);
        } else {
            System.out.println(win);
            System.out.println((mx + 1) + " " + (my + 1));
        }
    }

    public static int calculate(int num , int x, int y, int dx, int dy, int l) {

        int x1 = x + (dx * l);
        int y1 = y + (dy * l);

        if (!isTrue(x1, y1) || table[x1][y1] != num) {
            return 0;
        }

        return calculate(num, x, y ,dx, dy, l+1) + 1;
    }

    public static boolean isTrue(int x, int y) {
        if (x < 0 || y < 0 || x > ROW-1 || y > ROW-1) return false;
        return true;
    }


}
