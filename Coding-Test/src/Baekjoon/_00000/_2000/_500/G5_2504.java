package Baekjoon._00000._2000._500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G5_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String[] str = br.readLine().split("");

        int tmp = 1;
        int res = 0;
        for(int i = 0; i < str.length; i++) {
            String s = str[i];
            if(s.equals("(")){
                tmp*=2;
                stack.push(s);
            }
            else if(s.equals("[")){
                tmp*=3;
                stack.push(s);
            }
            else if(s.equals(")")){
                if(stack.isEmpty() || stack.peek().equals("[")){
                    res = 0;
                    break;
                }else if(str[i-1].equals("(")){
                    res += tmp;
                }
                tmp /= 2;
                stack.pop();
            }else{
                if(stack.isEmpty() || stack.peek().equals("(")){
                    res = 0;
                    break;
                }else if(str[i-1].equals("[")){
                    res += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) res = 0;
        System.out.println(res);
    }
}
