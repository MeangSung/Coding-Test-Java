package Baekjoon._1000._000;

import java.io.*;

public class B2_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = number(br.readLine());
        String second = number(br.readLine());

        long fs = Integer.parseInt(first+second);

        long third = multiple(br.readLine());

        System.out.println(fs * third);

    }

    private static String number(String s){
        switch (s){
            case "black":
                return "0";
            case "brown":
                return "1";
            case "red":
                return "2";
            case "orange":
                return "3";
            case "yellow":
                return "4";
            case "green":
                return "5";
            case "blue":
                return "6";
            case "violet":
                return "7";
            case "grey":
                return "8";
            case "white":
                return "9";
        }
        return "";
    }

    private static int multiple(String s){
        switch (s){
            case "black":
                return 1;
            case "brown":
                return 10;
            case "red":
                return 100;
            case "orange":
                return 1000;
            case "yellow":
                return 10000;
            case "green":
                return 100000;
            case "blue":
                return 1000000;
            case "violet":
                return 10000000;
            case "grey":
                return 100000000;
            case "white":
                return 1000000000;
        }
        return 0;
    }
}
