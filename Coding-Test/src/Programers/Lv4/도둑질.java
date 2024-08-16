package Programers.Lv4;

public class 도둑질 {
    public int solution(int[] money){
        int len = money.length;
        int[] dp0 = new int[len];
        int[] dpX = new int[len];

        dp0[0] = money[0];
        dp0[1] = money[0];

        dpX[0] = 0;
        dpX[1] = money[1];

        for(int i = 2; i <len; i++){
            dp0[i] = Math.max(dp0[i-1],dp0[i-2] + money[i]);
            dpX[i] = Math.max(dpX[i-1],dpX[i-2] + money[i]);
        }
        return Math.max(dp0[len-1],dpX[len-2]);
    }
}
