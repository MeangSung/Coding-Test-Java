package Baekjoon._20000._8000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_28086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"+-*/",true);
        int A,B;
        String s = st.nextToken();
        if(s.charAt(0)=='-') A = -Integer.parseInt(st.nextToken(),8);
        else A = Integer.parseInt(s,8);
        char op = st.nextToken().charAt(0);
        s = st.nextToken();
        if(s.charAt(0)=='-') B = -Integer.parseInt(st.nextToken(),8);
        else B = Integer.parseInt(s,8);
        System.out.print(cal(A,B,op));
    }

    static String cal(int a, int b, char op){
        long result = 0;
        switch(op){
            case '+': result = a+b; break;
            case '-': result = a-b; break;
            case '*': result = (long)a*b; break;
            default:{
                if(b != 0){
                    double tmp = (double)a/b;
                    result = (long)tmp;
                    if (a%b!=0 && tmp <0) --result;
                }
                else return "invalid";
            }
        }
        return result<0?"-"+Long.toOctalString(result*-1):Long.toOctalString(result);
    }
}
