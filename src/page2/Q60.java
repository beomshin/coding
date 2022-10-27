package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q60 {

    static int N;
    static int count=1;
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map.put(1, "0");

        for (int i=1; i <= 10; i ++) {

            for (int j=1; j < 10; j++) {
                calculate(i-1, j, String.valueOf(j));
            }

        }

        if (map.containsKey(N)) {
            System.out.println(map.get(N));
        } else {
            System.out.println(-1);
        }


    }

    public static void calculate(int digit, int prev, String num) {

        if (digit == 0) {
            map.put(++count, num);
            return;
        }


        for (int i=0; i < prev ; i++) {
            calculate(digit-1, i, num + i);
        }

    }



}
