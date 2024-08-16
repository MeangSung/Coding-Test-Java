package Programers.Lv3;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                answer++;
                dfs(computers,i,visited);
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int node, boolean[] visited){
        visited[node] = true;

        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(computers,i,visited);
            }
        }
    }
}
