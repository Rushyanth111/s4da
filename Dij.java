import java.util.*;

public class Dij{
	int[][] graph;
	int src;
	int size;
	int[] dist;
	Dij(int[][] graph, int src){
		this.graph = graph;
		this.src = src;
		this.size = graph.length;
		solve();
	}
	
	int minEdge(boolean[] vis, int[] dist){
		int min = 9999, minindex = -1;
		for(int i=0; i< dist.length; i++){
			if(vis[i] == false && min >= dist[i]){
				min = dist[i];
				minindex = i;
			}
		}
		return minindex;
	}
	void solve(){
		int[] dist = new int[size];
		
		boolean[] vis = new boolean[size];
		
		for(int i=0; i< size; i++){
			dist[i] = graph[src][i]==0?9999:graph[src][i];
			vis[i] = false;
		}
		dist[src] = 0;
		
		vis[src] = true;
		
		int ec = 0;
		
		while(ec < size - 1){
			int u = minEdge(vis, dist);
			System.out.println(u);
			vis[u] = true;
			
			for(int i=0; i< size; i++){
				if(graph[u][i] != 0 && vis[i] == false && dist[u] + graph[u][i] < dist[i]){
					dist[i] = graph[u][i] + dist[u];
				}
			}
			ec++;
		}
		this.dist = dist;
		print();
	}
	
	public static void main(String[] args){
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                      {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                      {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                      {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                      {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                      {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                      {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                      {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                      {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                     }; 
		Dij a = new Dij(graph,0);
	}
	
	void print(){
		for(int i=0; i< size - 1; i++){
			System.out.println("Distance to " + i + " from " + src + "is:" + dist[i]);
		}
	}
}