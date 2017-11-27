import java.util.PriorityQueue;
import java.util.Queue;

public class GraphAdjMatrix implements Graph {
	
	int[][] edgeGraph;

	public GraphAdjMatrix(int size) {
		// TODO Auto-generated constructor stub
		edgeGraph = new int[size][size];
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		//check for out of index?
		if(v1 < 0 || v2 < 0 || v1 > edgeGraph.length || v2 > edgeGraph.length || v1 == v2){
			System.out.println("Out of index range.");
			return;
		}
		edgeGraph[v1][v2] = 1;
	}

	@Override
	public void topologicalSort() {
		// TODO Auto-generated method stub
		int[] incident = new int[edgeGraph.length];
		//Queue sequence = new Queue(); array queue?
		for(int i = 0; i < edgeGraph.length; i++){
			System.out.println("inDegree{i): " + inDegree(i));
			incident[i] = inDegree(i);
		}
		
		Queue<Integer> sequence = new PriorityQueue<Integer>();
		
		int vertex = findZero(incident); 
		if(vertex != -1){
			sequence.add(vertex);
		}
		
		
	}
	
	protected int inDegree(int vertex){
		int degree = 0;
		for(int i = 0; i < edgeGraph.length; i++){
			if(edgeGraph[i][vertex] != -1){ //!= infinity, -1 for now
				degree++;
			}
		}
		return degree;
	}
	
	protected int findZero(int[] incident){
		for(int i = 0; i < incident.length; i++){
			if(incident[i] == 0){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int[] neighbors(int vertex) {
		// TODO Auto-generated method stub
		int[] arr = new int[edgeGraph.length];
		int newSize = 0;
		for(int i = 0; i < edgeGraph.length; i++){
			if(edgeGraph[vertex][i] == 1){
				newSize++;
				arr[i] = i;
			}		
		}
		int[] newArr = new int[newSize];
		int place = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				newArr[place] = arr[i];
				place++;
			}
		}
			
		return newArr;
	}

}
