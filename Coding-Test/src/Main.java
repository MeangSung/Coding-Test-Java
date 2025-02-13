import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] d = new int[10], w = new int[10];
    static int max = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        sol(0);

        System.out.println(max);
    }

    private static void sol(int idx) {
        if(idx == n){
            max = Math.max(max, cnt);
            return;
        }

        if(d[idx] <= 0){
            sol(idx+1);
            return;
        }

        boolean hitOccur = false;

        for(int i = 0; i < n; i++){
            if(i == idx || d[i] <= 0) continue;

            hitOccur = true;

            d[idx] -= w[i];
            d[i] -= w[idx];
            if(d[idx] <= 0) cnt++;
            if(d[i] <= 0) cnt++;
            sol(idx+1);
            if(d[idx] <= 0) cnt--;
            if(d[i] <= 0) cnt--;
            d[idx] += w[i];
            d[i] += w[idx];
        }

        if(!hitOccur) sol(idx+1);
    }
}