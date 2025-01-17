import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aArr = new int[n];
        int[] bArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol(n,m,aArr,bArr));
    }

    private static String sol(int n, int m, int[] aArr, int[] bArr){
        StringBuilder sb = new StringBuilder();

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        List<Integer> list = new ArrayList<>();

        for(int num : aArr){
            if(Arrays.binarySearch(bArr,num) < 0) list.add(num);
        }

        sb.append(list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }

        return sb.toString();
    }
}