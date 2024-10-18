package Baekjoon._20000._3000._300;

import java.util.Scanner;

public class S2_23304 {
    static String str;
    static boolean aka;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();

        if(str.length() == 1) aka = true;
        else{
            dfs(0,str.length()-1);
            for(int i = str.length() /2; i  > 0 && aka ; i /= 2){
                dfs(0, i-1);
            }
        }

        if(aka) {
            System.out.println("AKARAKA");
        }else{
            System.out.println("IPSELENTI");
        }
    }

    private static void dfs(int left, int right) {
        if(left >= right) {
            aka = true;
            return;
        }

        if(str.charAt(left) == str.charAt(right)) {
            dfs(left + 1, right - 1);
        }else{
            aka = false;
        }
    }
}
