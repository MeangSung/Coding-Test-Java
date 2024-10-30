package Baekjoon._00000._2000._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int height;
    int num;

    Top(int height, int num){
        this.height = height;
        this.num = num;
    }
}

public class G5_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Top(height, i));
            }else{
                while(true){

                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Top(height, i));
                        break;
                    }

                    Top top = stack.peek();

                    if(top.height >= height){
                        sb.append(top.num).append(" ");
                        stack.push(new Top(height, i));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }

}
