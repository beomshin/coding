package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q36 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[N+1];


        arr[1] = arr[2] = arr[3] = "*";
        int num = 1;

        while (num < N) {

            for (int i=1; i <= num; i++) {
                String star = arr[i];
                arr[i] = star.concat(star).concat(star);
                arr[i + num] = star.concat(star.replace("*", " ")).concat(star);
                arr[i + (num * 2)] = star.concat(star).concat(star);
            }
            num *= 3;
        }

        for (int i=1; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }
}
