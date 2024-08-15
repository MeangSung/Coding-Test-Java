package Programers.Lv2;

public class 타겟넘버 {
    public int solution(int[] numbers, int target){
        int n = numbers.length;
        int[] dp = new int[2001];
        dp[1000] = 1;
        for (int i = 0; i < n; i++) {
            int[] nextDP = new int[2001];
            for (int j = 0; j < 2001; j++) {
                if(dp[j] !=0){
                    nextDP[j + numbers[i]] += dp[j];
                    nextDP[j - numbers[i]] += dp[j];
                }
            }
            dp = nextDP;
        }
        return dp[target+1000];
    }
}
