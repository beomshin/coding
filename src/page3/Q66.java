package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q66 {

    /**
     * 파일 합치기 3
     * https://www.acmicpc.net/problem/13975
     *
     * 허프만 코딩
     *
     * 우선순위 큐를 이용하여 크기가 가장 작은 파일을 더한 값을 누적한다
     * 해당 합 파일을 다시 큐에 넣고 해당 큐가 empty 될때까지 수행시킨다.
     *
     * 파일간의 합의 최소값을 구할 수 있다.
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());

        for (int i=0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            long[] files = new long[K];

            st = new StringTokenizer(br.readLine());
            for (int j=0; j < K; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            long min = calculate(files);
            System.out.println(min);
        }

    }

    public static long calculate(long[] files) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i=0; i < files.length; i++){
            priorityQueue.add(files[i]);
        }

        long answer = 0;
        while (true) {

            long n1 = priorityQueue.poll();
            long n2 = priorityQueue.poll();

            long sum = n1 + n2;

            answer += sum;
            if(priorityQueue.isEmpty()) break;
            priorityQueue.add(sum);

        }


        return answer;
    }

}
