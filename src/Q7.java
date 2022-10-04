import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7 {

    static int N, M;
    static int answer = 0;
    static int[][] table;

    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, 0, -1};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];

        calculate(0);

        System.out.println(answer);
    }


    public static void calculate(int num) {

        if (num == (N*M)) {
            answer++;
            return;
        }

        int x = num % N;
        int y =  num / N;

        if (x-1 >= 0 && y-1 >=0) {

            if(isTrue(x, y)) {
                table[x][y] = 1;
                calculate(num + 1);
                table[x][y] = 0;
                calculate(num + 1);
            } else {
                calculate(num + 1);
            }

        } else {
            table[x][y] = 1;
            calculate(num + 1);
            table[x][y] = 0;
            calculate(num + 1);
        }
    }

    public static boolean isTrue(int x, int y) {
        for (int i=0; i < 3; i++) {
            if(table[x + dx[i]][y + dy[i]] == 0) return true;
        }

        return false;
    }
}
