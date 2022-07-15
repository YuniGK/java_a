package chr05;
public class ShortestPath {
    private int count; //노드 수
    private int[][] vertexMatrix; //그래프 표시
    private int[] distance;//최단거리
    private boolean[] visited;//방문여부
    private static int unlimit = 99999;//초기값

    public ShortestPath(int count){
        this.count = count;
        vertexMatrix = new int[count][count];
        distance = new int[count];
        visited = new boolean[count];
    }

    public void addEdages(int from, int to, int weight){
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public void calcShotestPath(int from){
        for (int i = 0; i < count; i++) {
            distance[i] = unlimit;
        }

        visited[from] = true;
        distance[from] = 0;

        //연결 노드 갱신
        for (int i = 0; i < count; i++) {
            if(visited[from] && vertexMatrix[from][i] != 0){
                distance[i] = vertexMatrix[from][i];
            }
        }

        for (int i = 0; i < count-1; i++) {
            int min = unlimit;
            int minIndex = -1;

            for (int j = 0; j < count; j++) {
                if(!visited[j] && distance[j] != unlimit){
                    if(distance[j] < min){
                        min = distance[j];
                        minIndex = i;
                    }
                }
            }

            visited[minIndex] = true;
            for (int j = 0; j < count; j++) {
                if(!visited[j] && vertexMatrix[minIndex][j] !=0){
                    if(distance[j]>distance[minIndex]+vertexMatrix[minIndex][j]){
                        distance[j] = distance[minIndex]+vertexMatrix[minIndex][j];
                    }
                }
            }
        }
    }

    public void showDistance(int from){
        for (int i = 0; i < count; i++) {
            System.out.println(from+" 노드로 부터 "+i+", 최단거리 "+distance[i]);
        }
    }

    public static void main(String[] args) {
        //최단 거리 구하기
        /*
          1
        1 - 0
        2 \/ 4
          2
           \ 1
           8
         4 - 3
         4 \/ 3
            5

        노드 v에 인접한 노드 w 에 대해 다음 조건이 성립하면 w 에 대한 최단 거리를 업데이트 한다
        (즉 원래 w로 가던 거리보다 v를 거쳐 가는 거리가 더 가까우면 w로 가는 거리는 v를 거쳐가는 것으로 최단 거리를 수정)
        Yw = Yv + Cvw if Yv + Cvw < Yw
        */
        ShortestPath graph = new ShortestPath(6);

        graph.addEdages(0, 1, 1);
        graph.addEdages(0, 2, 4);
        graph.addEdages(1, 2, 2);
        graph.addEdages(2, 3, 1);
        graph.addEdages(3, 4, 8);
        graph.addEdages(3, 5, 3);
        graph.addEdages(4, 5, 4);

        graph.calcShotestPath(0);
        graph.showDistance(0);
        /*
        0 노드로 부터 0, 최단거리 0
        0 노드로 부터 1, 최단거리 1
        0 노드로 부터 2, 최단거리 3
        0 노드로 부터 3, 최단거리 4
        0 노드로 부터 4, 최단거리 12
        0 노드로 부터 5, 최단거리 7
        */
    }
}
