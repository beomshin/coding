import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q26 {

    static int N, M;
    static ArrayList<Integer> crane, box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        crane = new ArrayList<>();

        for (int i=0; i < N; i++)  crane.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        box = new ArrayList<>();

        for (int i=0 ;i < M; i++) box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (box.get(0)> crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!box.isEmpty()) {

            time++;

            int idx=0;
            for (int i=0; i < N;) {
                if (box.isEmpty() || idx == box.size()) break;

                if (crane.get(i) >= box.get(idx)) {
                    i++;
                    box.remove(idx);
                } else {
                    idx++;
                }

            }


        }


        System.out.println(time);
    }
}
