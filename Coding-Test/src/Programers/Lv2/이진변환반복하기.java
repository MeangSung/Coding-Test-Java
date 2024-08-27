package Programers.Lv2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int cnt = 0;
        int cnt2 = 0;
        while(!s.equals("1")){
            String es = s.replace("0","");
            cnt+= s.length() - es.length();
            s = Integer.toBinaryString(es.length());
            cnt2++;
        }
        int[] res = {cnt2,cnt};
        return res;
    }
}
