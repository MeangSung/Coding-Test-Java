package Baekjoon._5000._600;

import java.util.Scanner;

public class B2_5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arr = sc.nextLine();

        int res = 0;
        for(char c : arr.toCharArray()) {

            if(c == 'P' || c == 'R' || c == 'Q' || c == 'S') {res+=8;}
            else if(c == 'T' || c == 'U' || c == 'V') {res += 9;}
            else if(c == 'X' || c == 'Y' || c == 'W' || c == 'Z') {res += 10;}
            else{
                res += (c-'A') /3 +3;
            }
        }

        System.out.println(res);
    }

}
