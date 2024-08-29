import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int[] top;
    private static int[] res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        top = new int[n+1];
        res = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n+1; i++){
            top[i] = Integer.parseInt(st.nextToken());
        }

        sol();

        // for(int r : res){
        //     System.out.printf(r+" ");
        // }
    }

    private static void sol(){

        for(int i = 2; i < n+1; i++){
            int cnt = 0;
            for(int j = i; j > 1; j--){
                System.out.println(cnt);

                if(top[i-1] >= top[i]){
                    cnt = i;
                    break;
                }
            }
            System.out.println(cnt);
            res[i-1] = cnt;
        }
    }
}