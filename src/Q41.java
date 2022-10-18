import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q41 {

    static int N, K;
    static int[] dx = {-1, 0, 1};
    static int[] mul = {1, 2, 1};
    static int[] add = {1, 0, 1};

    static class Node {
        int k, t;

        public Node(int k, int t) {
            this.k = k;
            this.t = t;
        }

    }

    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(N, 0));

        int time = Integer.MAX_VALUE;
        int[] dp = new int[MAX];
        boolean[] visited = new boolean[MAX];
        Arrays.fill(dp, MAX);

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            dp[node.k] = Math.min(dp[node.k], node.t);
            visited[node.k] = true;

            for (int i=0; i < 3 ; i++) {
                int x = node.k + dx[i];
                x = x * mul[i];
                int t = node.t + add[i];

                if(x < 0 || x > 100000) continue;

                if (!visited[x] || dp[x] > t) {
                    queue.add(new Node(x, t));
                }

            }

        }

        System.out.println(dp[K]);


    }
}
