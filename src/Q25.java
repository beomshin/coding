import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q25 {

    static int N, K;
    static int[] sensor;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if (N==1) {
            System.out.println(0);
            return;
        }

        sensor = new int[set.size()];

        int idx= 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            sensor[idx++] = iterator.next();
        }

        Arrays.sort(sensor);

        int sum = sensor[sensor.length-1] - sensor[0];

        for (int i=1; i < sensor.length; i++) {
            queue.add(sensor[i] - sensor[i-1]);
        }

        for (int i=0 ; i < K-1; i++) {
            sum -= queue.poll();
        }

        System.out.println(sum);

    }

}
