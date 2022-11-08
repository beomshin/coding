package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q82 {

    static class Code {
        int P, L;

        public Code(int P, int L) {
            this.P = P;
            this.L = L;
        }
    }

    static PriorityQueue<Code> max, min;
    static Map<Integer, Integer> count;

    /**
     * 문제 추천 시스템 Version 1
     * https://www.acmicpc.net/problem/21939
     *
     * 우선순위 큐와 해쉬맵을 이용하여 풀 수 있다
     *
     * 문제를 잘 읽어야하는데 recommend는 문제를 꺼내는것이 아니라 출력이다.
     *
     * 최대, 최소 값을 뽑는 경우 우선순위큐 + 해쉬맵문제가 많이 나온다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        count = new HashMap<>();
        max = new PriorityQueue<>(new Comparator<Code>() {
            @Override
            public int compare(Code o1, Code o2) {
                if (o1.L == o2.L) return o2.P - o1.P;
                return o2.L - o1.L;
            }
        });
        min = new PriorityQueue<>(new Comparator<Code>() {
            @Override
            public int compare(Code o1, Code o2) {
                if (o1.L == o2.L) return o1.P - o2.P;
                return o1.L - o2.L;
            }
        });

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            add(P, L);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if (type.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                add(P, L);

            } else if (type.equals("recommend")) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    max();
                } else  if (n == -1) {
                    min();
                }
            } else if (type.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                delete(P);
            }


        }

    }


    public static void add(int P, int L) {
        max.add(new Code(P, L));
        min.add(new Code(P, L));
        count.put(P, L);
    }

    public static void max() {

        while (true) {
            Code code = max.peek();
            int P = code.P;
            int L = code.L;

            if (count.get(P) != L) {
                max.poll();
            } else {
                System.out.println(P);
                break;
            }

        }


    }

    public static void min() {


        while (true) {
            Code code = min.peek();
            int P = code.P;
            int L = code.L;

            if (count.get(P) != L) {
                min.poll();
            } else {
                System.out.println(P);
                break;
            }

        }
    }

    public static void delete(int P) {
        count.put(P, 0);
    }
}
