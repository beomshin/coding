package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q40 {

    /** 오류문제 **/
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] circle = new int[N][2];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circle[i][0] = x - r;
            circle[i][1] = x + r;
        }

        Arrays.sort(circle, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for (int i=0 ; i < N;i++) {
            System.out.println(Arrays.toString(circle[i]));
        }

        for (int i=1 ; i < N; i++) {
            int start = circle[i][0];
            int end = circle[i][1];
            int prevEnd = circle[i-1][1];
            if (prevEnd >= start && prevEnd <= end) {
                System.out.println("NO");
                return;
            }

        }

        System.out.println("YES");

    }
}
