package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q16 {

    static Set<String> set;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] words = new String[N];

        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        for (int i=0 ; i < N; i++) {
            int[] alphabet = new int[26];
            for (char c : words[i].toCharArray()) alphabet[c - 'a'] += 1;
            calculate(alphabet, new String(), words[i].length());
        }

    }

    public static void calculate(int[] alphabet, String word, int size) {
        if (word.length() == size) {
            System.out.println(word);
            return;
        }

        for (int i=0; i < 26; i++) {
            if(alphabet[i] > 0) {
                alphabet[i] -= 1;
                calculate(alphabet, word + (char)(i + 'a'), size);
                alphabet[i] += 1;
            }
        }
    }
}
