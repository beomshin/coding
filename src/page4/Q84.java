package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q84 {

    /**
     * 카드 정렬하기
     * https://www.acmicpc.net/problem/1715
     *
     * 앞선 파일 정렬하기와 동일한 문제
     *
     * 우선순위 큐에 합친 값을 넣어 최소값을 계속 합쳐주며 나온값을 이용한다
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] card = new int[N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            card[i] = Integer.parseInt(st.nextToken());
        }

        int min = calculate(card);

        System.out.println(min);
    }

    public static int calculate(int[] card) {

        if (card.length == 1) {
            return 0;
        }

        int sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=0; i < card.length; i++) priorityQueue.add(card[i]);

        while (!priorityQueue.isEmpty()) {

            int n1 = priorityQueue.poll();
            int n2 = priorityQueue.poll();
            priorityQueue.add(n1+n2);
            sum += n1 + n2;
            if(priorityQueue.size() == 1) {
                priorityQueue.poll();
            }

        }

        return sum;
    }
}
