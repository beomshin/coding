import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q33 {

    static int K;
    static int M;
    static boolean[] visited;
    static int count =0;
    static Boolean[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[10];
        h = new Boolean[(int) (Math.pow(10, 5) + 1)];

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=1; i <= Math.pow(10,5); i++) {
            h[i] = check2(i);
        }

        for (int i=1; i < 10; i++) {
            visited[i] = true;
            calculate(i, 1);
            visited[i] = false;
        }

        System.out.println(count);

    }


    public static void calculate(int num, int deep) {

        if (deep == K) {
            if (cal1(num) && cal2(num)) {
                count++;
            }
            return;
        }

        for (int i=0; i < 10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                calculate(num * 10 + i , deep + 1);
                visited[i] = false;
            }
        }

    }

    public static boolean cal1(int num) {
        for (int i=1 ; i < num/2 + 1; i++) {
            int x = i;
            int y = num-i;
            if (x != y && check1(x,y )) {
                return true;
            }
        }
        return false;
    }

    public static boolean cal2(int num) {

        while (num%M == 0) num /= M;

        for (int i=2; i < num/2 + 1; i++) {
            int x = num/i;
            int y = i;
            if (x * y== num && check1(x,y)) return true;
        }
        return false;
    }

    public static boolean check1(int x, int y) {
        if (!h[x] || ! h[y]) return false;
        return true;
    }

    public static boolean check2(int n) {
        if (n == 0 || n == 1) return false;
        for (int i=2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
