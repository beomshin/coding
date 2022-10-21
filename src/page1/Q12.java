package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q12 {

    static int N, M;
    static int[] children;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        children = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            children[i] = Integer.parseInt(st.nextToken());
        }


        int max = children[N-1] - children[0];

        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());


        for (int i=1; i < N ; i++) {
            minus.add(children[i] - children[i-1]);
        }

        for (int i=0; i < M-1; i++) {
            max -= minus.poll();
        }

        System.out.println(max);
    }
}
