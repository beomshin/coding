import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] time : list) {
            if(queue.isEmpty()) {
                queue.add(time[1]);
            } else {

                if(queue.peek() <= time[0]) {
                    queue.poll();
                }

                queue.add(time[1]);
            }
        }

        System.out.println(queue.size());

    }
}
