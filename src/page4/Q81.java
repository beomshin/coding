package page4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q81 {

    /**
     * Trie (트라이)
     * https://github.com/tony9402/baekjoon/tree/main/trie
     *
     * 전화번호를 오름차순으로 정렬한 결과는 인접한 두 전화번호가 접두 번호인지 확인가면 된다
     *
     * 처음은 on2문제로 풀어 시간초과가 발생
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i=0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            String[] phones = new String[N];
            for (int j=0; j < N; j++) {
                phones[j] = br.readLine();
            }

            if (calculate(phones)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    public static boolean calculate(String[] phones) {

        Arrays.sort(phones);

        for (int i=0; i < phones.length-1; i++) {
            if (phones[i+1].startsWith(phones[i])) return false;
        }

        return true;
    }
}
