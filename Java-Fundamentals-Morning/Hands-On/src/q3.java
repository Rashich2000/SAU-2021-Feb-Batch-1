import java.util.*;


class exception1 extends Exception{
	
}

public class q3 {
	
	
	static boolean isPrime(int n) {
		//boolean flag = false;
		if(n==1) return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
			        return false;
			}
		}
		return true;
	
	}

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=1;i<=100;i++) {
			try {
			if(isPrime(i)==true) 
				throw new exception1();
			}
			catch(exception1 e){
				System.out.println("Exception! "+i+" is a Prime Number");
			}
			finally{System.out.println(i);}
			}
		}
}
