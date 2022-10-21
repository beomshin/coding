package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q30 {

    static int N;
    static int[][] table;
    static boolean[][] seat;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Set<Integer>[] likes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] people = new int[N*N][5];
        table = new int[N][N];
        seat = new boolean[N][N];
        likes = new Set[N*N+1];

        for (int i=0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < 5; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i< N*N; i++) {
            int no = people[i][0];
            likes[no] = new HashSet<>();
            for (int j=1; j < 5; j++) likes[no].add(people[i][j]);
        }

        for (int i=0; i < N*N; i++) {
            calculate(people[i]);
        }

        int sum = 0;

        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                int count = 0;
                for (int k =0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (check(x, y) && likes[table[i][j]].contains(table[x][y])) count++;
                }
                sum += Math.pow(10, count-1);
            }
        }

        System.out.println(sum);
    }

    public static void calculate(int[] it) {

        int no = it[0];

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        if(o1[2] == o2[2]) {
                            return o1[3] - o2[3];
                        }
                        return o1[2] - o2[2];
                    }
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        for (int i=0; i < N; i++) {
           for (int j=0; j < N; j++) {
               if(!seat[i][j]) {

                   int like = 0;
                   int empty = 0;

                   for (int k=0; k < 4 ; k++) {
                       int x = i + dx[k];
                       int y = j + dy[k];

                       if (check(x, y)) {
                           if (likes[no].contains(table[x][y])) like++;
                           else if(!seat[x][y]) empty++;
                       }
                   }

                    queue.add(new int[]{like, empty, i, j});
               }
           }
        }

        int[] data = queue.peek();
        int x = data[2];
        int y = data[3];
        table[x][y] = no;
        seat[x][y] = true;
    }

    public static boolean check(int x, int y) {
        if (x <0 || y < 0 || x > N-1 || y > N-1) return false;
        return true;
    }
}
