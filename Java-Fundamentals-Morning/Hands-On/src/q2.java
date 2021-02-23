import java.util.*;

public class q2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Map<Integer,String> map1= new TreeMap<>();
		System.out.println("Enter number of elems: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			Integer k=sc.nextInt();
			String v=sc.next();
			map1.put(k, v);
		}
		System.out.println("Original Map: "+map1.keySet());
		System.out.println("Reversed Map: "+ ((TreeMap<Integer, String>) map1).descendingKeySet());
	}
}
