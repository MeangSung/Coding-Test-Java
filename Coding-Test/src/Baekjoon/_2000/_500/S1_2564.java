package Baekjoon._2000._500;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2564 {
    public static void main(String[] args) {
        FastScan fs = new FastScan();

       int width = fs.nextInt();
       int length = fs.nextInt();
       int shopCnt = fs.nextInt();

       int[] load = new int[shopCnt];
        int police = 0;

       for(int i = 0; i < shopCnt+1; i++) {
           int loc = fs.nextInt();
           int dist = fs.nextInt();
           int temp = 0;
           switch (loc){
               case 1:
                   temp = dist;
                   break;
               case 2:
                   temp = width + length + width - dist;
                   break;
               case 3:
                   temp = width * 2 + length + length - dist;
                   break;
               case 4:
                   temp = width + dist;
                   break;
           }

           if(i < shopCnt){
               load[i] = temp;
           }
           else{
               police = temp;
           }
       }


        int res = 0;
        for(int i = 0; i < shopCnt; i++){
            int path1 = Math.abs(police - load[i]);
            int path2 = 2*width + 2*length - path1;
            res += Math.min(path1, path2);
        }
        System.out.println(res);

    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){return Integer.parseInt(next());}
    }
}
