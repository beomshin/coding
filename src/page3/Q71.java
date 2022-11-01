package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q71 {

    static int N;
    static int[] card;
    static Stack<Integer> temp;

    /**
     * 카드 섞기
     * https://www.acmicpc.net/problem/21315
     *
     * 구현 문제에 좀더 가까움
     * 스택과 큐를 이용하여 카드를 쌓아고 최종 단계를 비교한다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        temp = new Stack<>();

        st = new StringTokenizer(br.readLine());

        card = new int[N];

        for (int i=0; i < N; i ++) card[i] = Integer.parseInt(st.nextToken());

        int max = 0;

        while (Math.pow(2, max) < N) max++;

        for (int k1=1; k1 < max; k1++) {
            for (int k2=1; k2 < max; k2++) {

                Queue<Integer> queue = new LinkedList<>();
                for (int i=1; i <= N; i++) queue.add(i);

                temp.clear();

                calculate1(queue, k1);
                calculate2(queue, k1);
                while (!temp.isEmpty()) queue.add(temp.pop());
                calculate1(queue, k2);
                calculate2(queue, k2);
                ArrayList<Integer> list = new ArrayList<>();
                while (!temp.isEmpty()) list.add(temp.pop());

                if (check(list, card)) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }

        }

    }


    public static void calculate1(Queue<Integer> queue, int K) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < N - Math.pow(2, K); i++) stack.add(queue.poll());
        while (!stack.isEmpty()) temp.add(stack.pop());
    }

    public static void calculate2(Queue<Integer> queue, int K) {
        Stack<Integer> stack = new Stack<>();
        for (int i=2; i <= K+1; i++) {

            int count = (int) Math.pow(2, K-i+1);
            for (int j=0; j < count; j++) stack.add(queue.poll());
            while (!stack.isEmpty()) temp.add(stack.pop());
        }

        temp.add(queue.poll());
    }

    public static boolean check(ArrayList<Integer> list, int[] card) {
        for (int i=0; i < N; i++) {
            if (list.get(i)!=card[i]) {
                return false;
            }
        }
        return true;
    }


}

