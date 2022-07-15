public class UndirectedGraph {
    private int count;
    private int [][] verteMatrix;
    
    public UndirectedGraph(int count){
        this.count = count;
        verteMatrix = new int [count][count];
    }

    public void addEdges(int from, int to, int weight) {
        verteMatrix[from][to] =  weight;
        verteMatrix[to][from] =  weight;
    }

    public int[][] getMatrix(){
        return verteMatrix;
    }
}