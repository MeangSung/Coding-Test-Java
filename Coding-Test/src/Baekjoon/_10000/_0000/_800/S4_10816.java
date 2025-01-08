package Baekjoon._10000._0000._800;

import java.io.*;
import java.util.*;

public class S4_10816{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] deck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            deck[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(deck);

        int m = Integer.parseInt(br.readLine());

        int[] cards = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(deck, cards));
    }

    private static String solution(int[] deck, int[] cards){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cards.length; i++){
            int key = cards[i];

            int count = upperBound(deck,key) - lowerBound(deck,key);

            sb.append(count).append(" ");
        }

        return sb.toString();
    }

    private static int upperBound(int[] deck, int key){
        int left = 0;
        int right = deck.length;

        while(left < right){
            int mid = (left + right) / 2;
            int temp = deck[mid];

            if(key < temp){
                right = mid;
            }

            if(key >= temp){
                left = mid + 1;

            }
        }
        return left;
    }

    private static int lowerBound(int[] deck, int key){
        int left = 0;
        int right = deck.length;

        while(left < right){
            int mid = (right + left) / 2;
            int temp = deck[mid];

            if(key <= temp){
                right = mid;
            }

            if(key > temp){
                left = mid + 1;
            }
        }
        return left;
    }

}