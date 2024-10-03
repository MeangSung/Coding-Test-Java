package Programers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;

        int todayInt = changeDay(today);

        Map<String, Integer> term = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);

            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken()) * 28;

            term.put(key,value);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);

            int day = changeDay(st.nextToken());
            String key = st.nextToken();

            if(todayInt - day + 1 > term.get(key)){
                list.add(i+1);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;

    }

    private static int changeDay(String date){
        int day = 0;
        String[] stringArr = date.split("\\.");
//        System.out.println(stringArr[0]);
//        System.out.println(stringArr[1]);
//        System.out.println(stringArr[2]);

        day += Integer.parseInt(stringArr[0]) * 12 * 28;
        day += (Integer.parseInt(stringArr[1])-1) * 28;
        day += Integer.parseInt(stringArr[2]);

        return day;
    }

    public static void main(String[] args) {

        //1
//        String today="2022.05.19";
//        String[] terms = new String[]{"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        //2
        String today="2020.01.01";
        String[] terms = new String[]{"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }
}
