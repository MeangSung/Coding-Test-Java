package Programers.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    private static String[] dic = {"A","E","I","O","U"};
    private static List<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        find(0,"");
        int answer = 0;
        int size = list.size();

        for(int i = 0; i < size; i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }

    private static void find(int len, String word){
        list.add(word);
        if(len == 5) return;

        for(int i = 0; i < 5; i++){
            find(len+1,word+dic[i]);
        }
    }
}
