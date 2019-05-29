import java.util.*;
public class Prims{
	int[][] graph;
	int size;
	
	Prims(int[][] graph){
		this.graph = graph;
		this.size = graph.length;
		Solve();
	}
	
	void Solve(){	
		boolean[] visited = new boolean[size];
		
		for(int i=0; i<visited.length; i++){
			visited[i] = false;
		}
		
		visited[0] = true;
		Edge e = new Edge();
		while(e.size() < size - 1){
			int[] u = minEdge(visited);
			visited[u[0]] = true;
			visited[u[1]] = true;
			e.add(u[0],u[1]); 
		}
		e.print();
	}
	
	int[] minEdge(boolean V[]){
		int a=0, b=0, min = 9999; 
		for(int i = 0; i < size; i++)
			for(int j = 0; j< size; j++){
				if(graph[i][j]!=0 && V[j] == false &&min > graph[i][j])
				{
					a = i;
					b = j;
					min = graph[i][j];
				}
	
		}
	int arr[] = new int[2];
	arr[0] = a;
	arr[1] = b; 
	return arr;
	}
	
	public static void main(String[] args){
		int[][] graph = {{0, 2, 0, 6, 0}, 
                    {2, 0, 3, 8, 5}, 
                    {0, 3, 0, 0, 7}, 
                    {6, 8, 0, 0, 9}, 
                    {0, 5, 7, 9, 0}};
					Prims S = new Prims(graph);
	}
}

class Edge{
	Vector<Integer> A = new Vector<Integer>();
	Vector<Integer> B = new Vector<Integer>();
	
	void add(int a, int b){
		A.add(a);
		B.add(b);
	}
	
	int size(){
		return A.size();
	}
	
	void print(){
		for(int i=0; i < A.size(); i++){
			System.out.println(A.get(i) + " " + B.get(i));
		}
	}
}