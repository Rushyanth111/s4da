import java.util.*;

public class Prims{
	int[][] graph;
	int size;
	int src;
	
	Prims(int[][] graph, int src){
		this.graph = graph;
		this.size = graph.length;
		this.src = src;
		solve();
	}
	
	void solve(){
		Edge e = new Edge();
		boolean[] vis = new boolean[size];
		vis[src] = true;
		while(e.size() < size - 1){
			int[] a = findMinEdge(vis);
			e.add(a[0],a[1]);
			vis[a[1]] = true;
		}
	
	e.print();
	}
	
	int[] findMinEdge(boolean vis[]){
		Vector<Integer> U = new Vector<Integer>();
		Vector<Integer> Urev = new Vector<Integer>();
		
		for(int i=0; i<vis.length; i++){
			if(vis[i] == true)
				U.add(i);
			else
				
				Urev.add(i);
		}
		int a = 0, b = 0;
		int min = 99999;
		for(int i = 0; i < U.size(); i++){
			for(int j=0; j< Urev.size(); j++){
				if(graph[U.get(i)][Urev.get(j)]!=0 && graph[U.get(i)][Urev.get(j)] < min && vis[Urev.get(j)] == false){
					min = graph[U.get(i)][Urev.get(j)];
					a = U.get(i);
					b = Urev.get(j);
				}
			}
		}
		int[] arr = new int[2];
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
		Prims a = new Prims(graph,0);
	}
}

class Edge{
	Vector<Integer> A = new Vector<Integer>();
	Vector<Integer> B = new Vector<Integer>();
	
	void add(int a, int b){
		A.add(a);
		B.add(b);
	}
	
	int size(){return A.size();}
	
	void print(){
		for(int i = 0; i< A.size(); i++){
			System.out.println(A.get(i) + " " + B.get(i));
		}
	}
}