package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q50 {

    static PriorityQueue<Integer> minQ;
    static PriorityQueue<Integer> maxQ;
    static  HashMap<Integer, Integer> use;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            minQ = new PriorityQueue<>();
            maxQ = new PriorityQueue<>(Collections.reverseOrder());
            use = new HashMap<>();
            use.clear();
            minQ.clear();
            maxQ.clear();

            for (int i=0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                empty();
                if (command.equals("I")) {
                    insert(num);
                } else if (command.equals("D") && num == 1) {
                    max();
                } else if (command.equals("D") && num == -1) {
                    min();
                }
            }

            empty();

            if (maxQ.isEmpty() && minQ.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                if (minQ.isEmpty()) {
                    System.out.println(maxQ.peek() + " " + maxQ.peek());
                } else if (maxQ.isEmpty()) {
                    System.out.println(minQ.peek() + " " + minQ.peek());
                } else {
                    System.out.println(maxQ.peek() + " " + minQ.peek());
                }
            }

        }


    }

    public static void insert(int num) {
        maxQ.add(num);
        minQ.add(num);
        use.put(num, use.getOrDefault(num, 0) + 1);
    }

    public static void max() {
        if (!maxQ.isEmpty()) {
            int num = maxQ.poll();
            use.put(num, use.get(num) - 1);
        }
    }

    public static void min() {
        if (!minQ.isEmpty()) {
            int num = minQ.poll();
            use.put(num, use.get(num) - 1);
        }
    }


    public static void empty() {
        while (!minQ.isEmpty() && use.get(minQ.peek()) == 0) minQ.poll();
        while (!maxQ.isEmpty() && use.get(maxQ.peek()) == 0) maxQ.poll();
    }
}
