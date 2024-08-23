package Programers.Lv1;

import java.util.Arrays;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int f=0;
        int l=0;
        String res = "Yes";
        for (String g : goal){
            if(f < cards1.length && cards1[f].equals(g)){
                f++;
                continue;}
            if(l < cards2.length && cards2[l].equals(g)){
                l++;
                continue;}
            res="No";
        }
        return res;
    }
}
