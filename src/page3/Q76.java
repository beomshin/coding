package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q76 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] table = new int[N];
        Map<Long, Long> map = new HashMap<>();

        for (int i=0; i < N; i++) table[i] = Integer.parseInt(st.nextToken());


        long mul = 0;
        long count = 0;

        for (int i=0; i < N; i++) {

            mul += table[i];
            if (mul == K) count++;

            long target = mul - K;

            if(map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(mul, map.getOrDefault(mul, 0L) + 1);

        }


        System.out.println(count);

    }
}
