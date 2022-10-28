package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q61 {

    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    static int r, c;
    static int count = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);

        dfs(0, 0, len);

        System.out.println(answer);
    }



    public static void dfs(int x, int y, int len) {

        if(len==1) {

            if (x==r && c==y) {
                answer = count;
            } else {
                count++;
            }

            return;
        }

        len /= 2;

        for (int i=0; i < 4; i++) {
            int x1 = x + (dx[i] * len);
            int y1 = y + (dy[i] *len);

            if (check(x1, y1, x1 + len, y1 + len)) {
                dfs(x1, y1, len);
            } else {
                count += (len * len);
            }
        }
    }


    public static boolean check(int x1, int y1, int x2, int y2) {
        if (x1 <= r && x2 >= r && y1 <= c && y2 >= c) return true;
        return false;
    }
}
