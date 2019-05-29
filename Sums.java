import java.util.*;

public class Sums{
	int[] nos;
	int sum;
	
	Sums(int sum, int[] nos){
		this.sum = sum;
		this.nos = nos;
		
		Vector<Integer> V = new Vector<Integer>();
		boolean vis[] = new boolean[nos.length];
		for(int i=0; i<nos.length; i++){
			vis[i] = false;
		}
		solve(V,0,vis);
	}
	
	int add(Vector<Integer> V){
		int sum = 0;
		for(int i=0; i< V.size(); i++) sum+= V.get(i);
		return sum;
	}
	
	boolean solve(Vector<Integer> V, int pos, boolean vis[]){
		if(add(V) == this.sum){
			printSol(V);
			return true;
		}
		
		for(int i=pos; i < nos.length; i++){
			if(add(V) + nos[i] <= sum && vis[i] == false){
				V.add(nos[i]);
				vis[i] = true;
				Vector<Integer> Vclone = (Vector<Integer>)V.clone();
				if(solve(Vclone,pos+1, vis) == false){ 
					vis[i] = false;
					V.remove(V.size() -1);
				}
			}
		}
		return false;
	}
	
	void printSol(Vector<Integer> V){
		System.out.println(V);
	}
	
	public static void main(String[] args){
		int[] nos = {1,2,3,4,5,6,7,8,9,10};
		Sums s = new Sums(10, nos);
	}
}