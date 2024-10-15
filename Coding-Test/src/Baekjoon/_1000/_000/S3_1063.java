package Baekjoon._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        String[] move = new String[n];

        for (int i = 0; i < n; i++) {
            move[i] = br.readLine();
        }

        String[] res = sol(king,stone,move);

        System.out.println(res[0] + "\n" + res[1]);
    }

    private static String[] sol(String king, String stone, String[] move) {

        for (String m : move) {
            int[] directions = toDirection(m);

            char kw = king.charAt(0);
            char kl = king.charAt(1);

            char cw = (char) (kw + directions[0]);
            char cl = (char) (kl + directions[1]);

            if(cw < 'A' || cw > 'H') continue;
            if(cl < '1' || cl > '8') continue;

            char sw = stone.charAt(0);
            char sl = stone.charAt(1);

            if (cw == sw && cl == sl) {
                char csw = (char) (sw + directions[0]);
                char csl = (char) (sl + directions[1]);

                if(csw < 'A' || csw > 'H') continue;
                if(csl < '1' || csl > '8') continue;

                sw = csw;
                sl = csl;
            }

            king = String.valueOf(new char[]{cw,cl});
            stone = String.valueOf(new char[]{sw,sl});
        }
        return new String[] {king,stone};
    }

    private static int[] toDirection(String m) {

        int[] directions = new int[2];
        for (int i = 0; i < m.length(); i++) {
            switch (m.charAt(i)) {
                case 'R':
                    directions[0]++;
                    break;
                case 'L':
                    directions[0]--;
                    break;
                case 'T':
                    directions[1]++;
                    break;
                case 'B':
                    directions[1]--;
                    break;
            }
        }

        return directions;
    }
}
