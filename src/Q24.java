import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q24 {

    static ArrayList<Integer>[] table;
    static int N, M;
    static boolean[] visited;
    static int[] order;
    static boolean[] isCut;
    static int no = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        table = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1];
        isCut = new boolean[N+1];

        for (int i=1; i <= N; i++) table[i] = new ArrayList<>();

        for (int i=0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            table[n1].add(n2);
            table[n2].add(n1);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        calculate(1, true);

        for (int i=0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            boolean flag = false;

            if (n1 == 1) {
                flag = isCut[n2];
            } else if (n1 == 2) {
                flag= true;
            }

            System.out.println(flag ? "yes" : "no");
        }

    }

    public static int calculate(int idx, boolean root) {

        order[idx] = no++;
        visited[idx] = true;
        int ret = order[idx];
        int child = 0;

        for (int i=0; i < table[idx].size(); i++) {

                int c = table[idx].get(i);

                if (visited[c]) {
                    ret = Math.min(ret, order[c]);
                    continue;
                }

                child++;
                int prev = calculate(table[idx].get(i), false);

                if (!root && prev >= order[idx]) {
                    isCut[idx] = true;
                }

                ret = Math.max(ret, prev);
            }

            if (root && child >= 2) isCut[idx] = true;


        return ret;
    }

}
