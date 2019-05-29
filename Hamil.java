import java.util.*;


public class Hamil{
	int size;
	int[][] graph;
	
	Hamil(int[][] graph){
		this.size = graph.length;
		this.graph = graph;
		
		boolean visited[] = new boolean[size];
		for(int i=0; i< size; i++){
			visited[i] = false;
		}
		
		Vector<Integer> V = new Vector<Integer>();
		V.add(0);
		Solve(visited,V);
	}
	
	boolean checkpath(Vector<Integer> v){
		int last = v.get(v.size() - 1);
		if(graph[last][0] == 1)
			return true;
		return false;
	}
	
	boolean checkVis(boolean[] visited, int i, Vector<Integer> v){
		if(visited[i] == false && graph[i][v.get(v.size() - 1)] == 1)
			return false;
		return true;
	}
	boolean Solve(boolean[] visited, Vector<Integer> path){
		if(path.size() == size){
			if(checkpath(path) == true)
				printSol(path);
			else
				return false;
		}
		
		for(int i = 1; i< size; i++){
			if(checkVis(visited,i,path) == false){
				path.add(i);
				visited[i] = true;
				Vector<Integer> clone = (Vector)path.clone();
				if(Solve(visited, clone) == true){
					return true;
				}
				path.remove(path.size() - 1);
				visited[i] = false;
			}
		}
	return false;
	}
	void printSol(Vector<Integer> v){
		v.add(0);
		System.out.println(v);
		v.remove(v.size() - 1);
	}
	
	public static void main(String[] args){
		int graph1[][] = {{0, 1, 0, 1, 0},  
                        {1, 0, 1, 1, 1},  
                        {0, 1, 0, 0, 1},  
                        {1, 1, 0, 0, 1},  
                        {0, 1, 1, 1, 0}}; 
		Hamil a = new Hamil(graph1);
	}
}