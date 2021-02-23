import java.util.*;

public class q1 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String: ");
		String str1=sc.nextLine();
		System.out.println("Regex: ");
		String regex=sc.nextLine();
		System.out.println("To be replace with:");
		String substr=sc.nextLine();	
		String ans=str1.replaceAll(regex,substr );
		System.out.println("Ans is: "+ans);
	}
}
