package page3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q76 {

    /**
     * 수들의 합 4
     * https://www.acmicpc.net/problem/2015
     *
     * 누적값들을 맵에 담아두고 해당 누적합과 합쳐 k개를 만들수 있는 누적합의 개수를 계산하여
     * 총 COUNT를 증가시킨다.
     *
     * @param args
     * @throws IOException
     */
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
