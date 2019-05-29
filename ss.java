public class ss extends a{
	int y= 100;
	ss(){
		super();
		System.out.println("B CALLED");
		System.out.println(x + " " + y);
	}
	public static void main(String[] args){
		ss s = new ss();
		
	}
}

class a{
	int x;
	a(){
		System.out.println("A IS CALLED");
		x=10;
	}
}
