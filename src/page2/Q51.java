package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q51 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> hardQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> easyQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i=0 ; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            hardQ.add(new int[]{P, L});
            easyQ.add(new int[]{P, L});
            counts.put(P, counts.getOrDefault(P, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            empty(hardQ, easyQ, counts);
            if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                hardQ.add(new int[]{P, L});
                easyQ.add(new int[]{P, L});
                counts.put(P, counts.getOrDefault(P, 0) + 1);
            } else if(cmd.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                counts.put(P, counts.get(P) - 1);
            } else if(cmd.equals("recommend")) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) {
                    System.out.println(hardQ.peek()[0]);
                } else if (n == -1) {
                    System.out.println(easyQ.peek()[0]);
                }

            }

        }


    }

    public static void empty(PriorityQueue<int[]> hardQ, PriorityQueue<int[]> easyQ,  HashMap<Integer, Integer> counts) {
        while (!hardQ.isEmpty() && counts.get(hardQ.peek()[0]) == 0) hardQ.poll();
        while (!easyQ.isEmpty() && counts.get(easyQ.peek()[0]) == 0) easyQ.poll();
    }
}
