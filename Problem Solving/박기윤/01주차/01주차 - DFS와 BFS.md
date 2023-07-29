# DFS와 BFS

## 풀이

- bfs의 경우 큐를 통해, 현재 노드와 인접한 모든 노드를 먼저 방문한다.
- dfs의 경우 recursion을 통해, 현재 노드와 인접한 노드를 방문하고, 방문이 완료된 해당 노드의 인접한 노드를 방문한다.
- 이 때, 인접한 노드가 여러개 일 수도 있기 때문에, 정렬를 하고 방문한다.
  - 사전에 정렬하는 메소드를 한 번 호출하는 방법이 좋으나, 작성된 코드의 경우에는 인접한 노드를 방문하기 직전에, 정렬하기 때문에 좋은 방법은 아님.
<br/>
## 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(tokenizer.nextToken());
            int dst = Integer.parseInt(tokenizer.nextToken());
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        boolean[] table = new boolean[n+1];

        List<Integer> visit = new ArrayList<>();

        dfs(graph, v, table, visit);
        StringBuilder answerBuilder = new StringBuilder();
        for(Integer node : visit) {
            answerBuilder.append(node).append(" ");
        }
        String answer = answerBuilder.toString().trim();
        System.out.println(answer);


        Arrays.fill(table, false);
        bfs(graph, v, table);

    }

    public static void bfs(List<List<Integer>> graph, int start, boolean[] table) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        table[start] = true;
        StringBuilder answerBuilder = new StringBuilder();

        while(!q.isEmpty()) {

            int currentVertex = q.poll();
            answerBuilder.append(currentVertex).append(" ");
            List<Integer> neighbors = graph.get(currentVertex);
            neighbors = neighbors.stream().sorted().collect(Collectors.toList());
            for(Integer neighbor : neighbors) {
                if(!table[neighbor]) {
                    table[neighbor] = true;
                    q.add(neighbor);
                }
            }

        }

        String answer = answerBuilder.toString().trim();
        System.out.println(answer);

    }

    public static void dfs(List<List<Integer>> graph, int start, boolean[] table, List<Integer> visit) {

        visit.add(start);
        table[start] = true;
        List<Integer> neighbors = graph.get(start).stream().sorted().collect(Collectors.toList());
        for(Integer neighbor: neighbors) {
            if(!table[neighbor]) {
                dfs(graph, neighbor, table, visit);
            }
        }

    }

}


```
