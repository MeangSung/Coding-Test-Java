import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[][] uni;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        uni = new int[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                uni[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int solution(){
        for(int i = 0; i < m; i++){
            compress(uni[i]);
        }

        int res = 0;
        for(int i = 0; i < m-1; i++){
            for(int j = i+1; j < m; j++){
                if(compare(uni[i],uni[j])) res++;
            }
        }
        return res;
    }

    private static void compress(int[] arr){
        List<Integer> v = new ArrayList<>();
        for(int num : arr) v.add(num);

        Collections.sort(v);
        v = new ArrayList<>(new LinkedHashSet<>(v));

        for(int i = 0; i < n; i++){
            arr[i] = Collections.binarySearch(v, arr[i]);
        }
    }

    private static boolean compare(int[] a, int[] b){
        for(int i = 0; i < n; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

}