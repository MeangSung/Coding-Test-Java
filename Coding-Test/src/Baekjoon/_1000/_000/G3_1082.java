package Baekjoon._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_1082 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int money = Integer.parseInt(br.readLine());

        System.out.println(sol(n,prices,money));

        br.close();
    }

    private static String sol(int n, int[] prices, int money){

        int min = 50;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(min >= prices[i]){
                min = prices[i];
                idx = i;
            }
        }

        char[] resultNum = new char[51];
        int cnt = 0;
        while(money >= min){
            resultNum[cnt++] = (char) (idx + '0');
            money -= min;
        }

        int start = 0;
        for(int i = 0; i < cnt; i++){
            for(int j = n-1; j >=0; j++){
                if(prices[j] <= money + min){
                    resultNum[i] = (char) (j + '0');
                    money += min - prices[j];
                    break;
                }
            }

            if(resultNum[start] == '0'){
                start++;
                money+=min;
            }
        }

        if(start == cnt){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start; i < cnt; i++){
            sb.append(resultNum[i]);
        }
        return sb.toString();
    }
}
