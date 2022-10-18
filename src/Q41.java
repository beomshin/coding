import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q41 {

    static int N, K;

    static class Node {
        int l, t;

        public Node(int l, int t) {
            this.l = l;
            this.t = t;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(N, 0));

        int time = Integer.MAX_VALUE;


        while (!queue.isEmpty()) {

            Node node = queue.poll();


            if (node.t > time) continue;

            if (node.l == K) {
                time = Math.min(time, node.t);
                continue;
            }






        }


        System.out.println(time);


    }
}
