import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<int[]> timeTable = new ArrayList<>();

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timeTable.add(new int[]{start, end});
        }

        Collections.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] time : timeTable) {
            if(rooms.isEmpty()) rooms.add(time[1]);
            else {
                if (rooms.peek() <= time[0]) {
                    rooms.poll();
                }
                rooms.add(time[1]);
            }
        }

        System.out.println(rooms.size());
    }
}
