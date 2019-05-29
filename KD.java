
public class KD{
	static int knapSack(int weight, int weightList[], int valList[], int itemcount){
		int[][] KnapSack = new int[itemcount+1][weight+1];
		int i, w;
		
		for(i = 0; i <= itemcount; i++){
			for(w = 0; w<= weight; w++){
				if(i==0 || w==0)
					KnapSack[i][w] = 0;
				else if(weightList[i-1] <= w)
					KnapSack[i][w] = Math.max(KnapSack[i-1][w], KnapSack[i-1][w - weightList[i-1]] + valList[i-1]);
				else
					KnapSack[i][w] = KnapSack[i-1][w];
			}
		}
		return KnapSack[itemcount][weight];
	}
	
	public static void main(String[] args){
		int W = 50;
		int[] val = {60,100,120};
		int[] wt = {10,20,30};
		System.out.println(knapSack(W,wt, val,val.length));
	}
}