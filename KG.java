public class KG{
	double[] ratio;
	boolean[] added;
	public void KGSolve(int weight, double[] WeightList, double[] Valuelist, int itemcount){
		this.ratio = new double[itemcount];
		this.added = new boolean[itemcount];
		for(int i=0; i< itemcount; i++){
			ratio[i] = WeightList[i]/Valuelist[i];
			added[i] = false;
		}
		
		int cwei = 0;
		int cprof = 0;
		while(cwei < weight){
			int u = getHighest();
			if(u == -1) break;
			added[u] = true;
			if(cwei + WeightList[u] <= weight){
				cwei += WeightList[u];
				cprof += Valuelist[u];
			}
		}
		
		System.out.println(cwei + " " + cprof);
	}
	
	int getHighest(){
		int index = -1;
		double prof = 0;
		for(int i=0;i<ratio.length; i++){
			if(prof < ratio[i] && added[i] == false){
				index = i;
				prof = ratio[i];
			}
		}
		return index;
	}
	
	public static void main(String[] args){
		double val[] = {60, 100, 120}; 
		double wt[] = {10, 20, 30}; 
		int  W = 50;
		int n = val.length;
		KG k = new KG();
		k.KGSolve(W,wt,val,n);
	}
}