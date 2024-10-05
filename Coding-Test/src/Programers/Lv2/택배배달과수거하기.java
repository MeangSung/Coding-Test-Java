package Programers.Lv2;

public class 택배배달과수거하기 {

    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {

            int delivery = 0;
            int pickup = 0;
            long res = 0;

            for(int i = n-1; i >= 0; i--){
                delivery += deliveries[i];
                pickup += pickups[i];

                while(delivery > 0 || pickup > 0){
                    delivery -= cap;
                    pickup -= cap;
                    res += (i+1) *2;
                }
            }

            return res;

        }
    }
}
