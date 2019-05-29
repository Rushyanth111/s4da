import java.util.*;


public class Floyds{
	public static void main(){
		int graph[][] = { {1, 1, 0, 1}, 
                        {0, 1, 1, 0}, 
                        {0, 0, 1, 1}, 
                        {0, 0, 0, 1} 
                      }; 
					  
		
	for(int k = 0; k < graph.length; k++){
		for(int i = 0; i< graph.length; i++){
			for(int j =0; j< graph.length; j++){
				graph[i][j] = graph[i][j] || cc(graph[i][k],graph[k][j]);
			}
		}
	}
	
	for(int i = 0; i< graph.length; i++){
		for(int j =0; j< graph.length; j++){
			System.out.print(graph[i][j]);
		}
		System.out.println("");
	}

}
	boolean cc(int a, int b){
		return a*b==1?
	}
}