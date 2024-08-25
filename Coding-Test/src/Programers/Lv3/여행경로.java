package Programers.Lv3;
import java.util.*;

public class 여행경로 {
    static int length;
    static String[][] Tickets;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        length = tickets.length;
        Tickets = tickets;
        visited = new boolean[length];

        dfs("ICN","ICN",0);
        Collections.sort(list);
        return list.get(0).split(",");
    }

    private static void dfs(String start,String path, int depth){
        if(depth == length){
            list.add(path);
            return;
        }
        else{
            for(int i = 0; i < length; i++){
                if(!visited[i] && Tickets[i][0].equals(start)){
                    visited[i] = true;
                    dfs(Tickets[i][1],path+","+Tickets[i][1],depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
