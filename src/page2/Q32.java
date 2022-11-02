package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q32 {

    static int N;
    static long[][] city;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        city = new long[N][2];
        long total = 0;

        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            city[i][0] = x;
            city[i][1] = a;
            total += a;
        }

        Arrays.sort(city, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0]) return (int) (o1[1] - o2[1]);
                return (int) (o1[0] - o2[0]);
            }
        });

        long sum = 0;

        for (int i=0; i < N; i++) {

            sum += city[i][1];

            if (sum >= ((double)total/2)) {
                System.out.println(city[i][0]);
                return;
            }

        }


    }
}
