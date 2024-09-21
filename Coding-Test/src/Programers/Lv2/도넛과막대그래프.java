package Programers.Lv2;

import java.util.HashMap;

public class 도넛과막대그래프 {
    public int[] solution(int[][] edges) {
    int[] answer = new int[4];

    HashMap<Integer, Integer> in = new HashMap<>();
    HashMap<Integer, Integer> out = new HashMap<>();

    for(int[] edge : edges){
        out.put(edge[0], out.getOrDefault(edge[0],0)+1);
        in.put(edge[1], in.getOrDefault(edge[1],0)+1);
    }

    for(Integer key : out.keySet()){
        if(out.get(key) > 1){
            if(!in.containsKey(key)){
                answer[0] = key;
            }
            else{
                answer[3]+=1;
            }
        }
    }

    for(Integer key : in.keySet()){
        if(!out.containsKey(key)){
            answer[2] +=1;
        }
    }
    answer[1] = out.get(answer[0]) - answer[2] - answer[3];

    return answer;
}

}