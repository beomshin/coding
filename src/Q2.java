import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Q2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<int[]> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());

        for (int i=0; i < n; i++ ) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list.add(new int[]{n1, n2});
        }

        Collections.sort(list, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }

        });

        final int[] end = {0};
        final AtomicInteger[] count = {new AtomicInteger()};

        list.stream().forEach(it -> {
            if (it[0] >= end[0]) {
                count[0].getAndIncrement();
                end[0] = it[1];
            }

        });

        System.out.println(count[0].get());
    }

}
