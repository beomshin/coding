package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q91 {

    /**
     * 선발 명단
     * https://www.acmicpc.net/problem/3980
     *
     * 간단한 dfs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < C; i++) {

            int[][] player = new int[11][11];

            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    player[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(calculate(player));
        }

    }


    public static int calculate(int[][] team) {
        return generateTeam(team, 0, 0, new boolean[11]);
    }


    public static int generateTeam(int[][] team, int player, int sum, boolean[] visited) {

        if (player == 11) {
            return sum;
        }

        int max = 0;

        for (int i=0; i < 11; i++) {
            if (team[player][i] == 0 || visited[i]) continue;
            visited[i] = true;
            max = Math.max(max, generateTeam(team, player+1, sum + team[player][i], visited));
            visited[i] = false;
        }

        return max;
    }
}
