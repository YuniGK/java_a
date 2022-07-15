import java.util.Stack;

public class Dfs {
    int count;
    boolean[] visited;
    Stack<Integer> stack;
    int [][] matrix;

    public Dfs(int count){
        this.count = count;

        visited = new boolean[count];
        stack = new Stack<>();
    }

    public void dfsTraversal(){
        //방문 여부를 체크해준다.
        stack.push(0);
        visited[0] = true;

        while(stack.isEmpty() == false){
            int node = stack.pop();

            System.out.print(node+" ");

            for (int i = 0; i < count; i++) {
                if(matrix[node][i] != 0 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        /* 그래프 탐색 
        DFS - 한 반향으로 이동한다. stack
        BFS - 자기와 인접한 부분을 모두 본 후 다음으로 이동, queue사용 
        */

        //그래프 생성
        int count = 8;

        UndirectedGraph graph = new UndirectedGraph(count);
        /*
          0
         /  \
         1   2
        / \ / \
        3 4-5  6
        |
        7
        */
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(3, 7, 1);
        graph.addEdges(4, 5, 1);

        Dfs dfs = new Dfs(count);
        dfs.matrix = graph.getMatrix();

        dfs.dfsTraversal();
        //0 2 6 5 4 1 3 7
    }
}