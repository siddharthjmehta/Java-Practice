public class TowerPrac {

	private int total;
	private String rod1;
	private String rod2;
	private String rod3;
	
	public TowerPrac (int total,String rod1,String rod2,String rod3){
		this.rod1=rod1;
		this.rod2=rod2;
		this.rod3=rod3;
		this.total=total;
	}
	public void Solve(){
		System.out.println("Steps for solving "+total+" tower puzzle");
		System.out.println("solution\n");
		Solve(total, rod1, rod2, rod3);
	}
	public void Solve(int size,String a,String b,String c){
		if (size==1){
			System.out.println("move from "+a+" to "+b);
		}
		else{
			Solve(size-1,a,c,b);
			Solve(1, a, b, c);
			Solve(size-1, c, b, a);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerPrac t=new TowerPrac(4, "A", "B", "C");
		t.Solve();
	}

}
