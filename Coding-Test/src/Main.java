import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] temp;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        temp = new int[m];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int comp = Integer.parseInt(st.nextToken());
            if(!list.contains(comp)) {
                list.add(comp);
            }
        }

        sol(0,0);

        System.out.println(sb);
    }

    private static void sol(int st, int cnt){
        if(cnt == m){
            for(int num : temp) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = st; i < list.size(); i++){
            temp[cnt] = list.get(i);
            sol(i, cnt+1);
        }
    }
}