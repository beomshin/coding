package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q22 {

    static int[] answer;
    static int N;
    static int[][] subjects;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        subjects = new int[M][2];
        answer = new int[N+1];
        Arrays.fill(answer, 1);

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            subjects[i][0] = n1;
            subjects[i][1] = n2;
        }

        Arrays.sort(subjects, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0]-o2[0];
            }
        });

        for (int i=0; i <M; i++) {
            int first = subjects[i][0];
            int second = subjects[i][1];

            answer[second] = Math.max(answer[first] + 1, answer[second]);
        }

        for (int i=1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }



}
