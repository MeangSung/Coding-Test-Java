package Programers.Lv1;

public class 푸드파이트대회 {
    public String solution(int[] food) {
        String first = "";
        String last = "";
        for (int i=1; i<food.length; i++){
            for(int j=0; j < food[i]/2; j++){
                first = first+i;
                last = i+last;
            }
        }
        return first+0+last;
    }
}
