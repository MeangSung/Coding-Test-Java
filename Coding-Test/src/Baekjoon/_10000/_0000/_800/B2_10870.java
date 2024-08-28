package Baekjoon._10000._0000._800;

import java.util.Scanner;

class B2_10870{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int pre = 0;
        int cur = 1;
        int n = scan.nextInt();


        if(n == 0) cur= 0;
        else if(n == 1) cur= 1;
        else{
            for(int i = 2; i < n+1; i++){
                int tmp = cur;
                cur = cur+pre;
                pre = tmp;
            }
        }
        System.out.println(cur);
    }
}