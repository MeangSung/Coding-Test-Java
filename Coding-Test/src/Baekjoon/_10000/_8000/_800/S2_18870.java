package Baekjoon._10000._8000._800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class S2_18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(sol(N,arr));
    }

    private static String sol(int N, int[] arr) {
        StringBuilder sb = new StringBuilder();

        List<Integer> uni = makeUniqueList(arr);

        for(int num : arr){
            int p = binarySearch(uni,num);
            sb.append(p).append(" ");
        }
        return sb.toString();
    }

    private static int binarySearch(List<Integer> list, int key) {
        int st = 0;
        int en = list.size();

        while(st < en) {
            int mid = (st + en) / 2;
            int temp = list.get(mid);

            if(key > temp) st = mid + 1;
            if(key <= temp) en = mid;
        }
        return st;
    }

    private static List<Integer> makeUniqueList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        Collections.sort(list);
        list = new ArrayList<>(new LinkedHashSet<>(list));
        return list;
    }
}
