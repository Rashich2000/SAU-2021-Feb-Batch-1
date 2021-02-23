import java.util.*;  
//import java.util.Stack;
public class q1 {
	
	public static boolean precedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
            return false;
        if ( ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) || ((op1=='+'||op1=='-')&&(op2=='+'||op2=='-')))       
            return false;
        else
            return true;
	}
	
	public static int operation(int a, int b,char op)
	{
		switch (op)
		{
			case '+':
			return a + b;
			case '-':
			return b - a;
			case '*':
			return a * b;
			case '/':
			return b / a;
			case '%':
			return b%a;
		}
		return 0;
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);  
		System.out.print("No. of expressions: ");  
		int n= sc.nextInt();  
		
		for(int i=0;i<n;i++) {
			System.out.print("Enter an expression: ");  
			String exp= sc.next();
			//exp="0"+exp;
			if(exp.charAt(0)=='-') {
				exp = '-'+exp.substring(1).replaceAll("-", "+-");
			}
			else {exp=exp.replaceAll("-", "+-");}
			exp=exp.replaceAll("\\++-", "+-");
			//exp="0"+exp;
			Stack<Integer> operands=new Stack<>();
			Stack<Character> operator=new Stack<>();
			for(int j=0;j<exp.length();j++) {
				if(exp.charAt(j)=='(') {
					operator.push('(');
				}
				else if((exp.charAt(j)>='0' && exp.charAt(j)<='9')|| (exp.charAt(j) == '-')) {
					StringBuffer buf = new StringBuffer();
					while((j<exp.length() && exp.charAt(j)>='0' && exp.charAt(j)<='9')||(exp.charAt(j) == '-')||(exp.charAt(j) == '.')) {
						buf.append(exp.charAt(j));
						if(j==(exp.length()-1)) {
							break;
						}
						else j++;
						
					}
					operands.push(Integer.parseInt(buf.toString()));
					//System.out.println(operands.peek());
					if(j<exp.length()-1)j--;
				}
				else if(exp.charAt(j)=='+' || exp.charAt(j)=='-'
						|| exp.charAt(j)=='*' || exp.charAt(j)=='/' || exp.charAt(j)=='%') {
					while(!operator.empty() && precedence(exp.charAt(j), operator.peek())) {
						operands.push(operation(operands.pop(),operands.pop(),operator.pop()));
					}
					operator.push(exp.charAt(j));
					//System.out.println(operator.peek());
				}
				else if(exp.charAt(j)==')') {
					while (operator.peek() != '(') {
		                operands.push(operation(operands.pop(),operands.pop(),operator.pop()));
		                
					}
					operator.pop();
				}
		        
				
			}
			while (!operator.empty()) {
				if(!operands.empty())
	            operands.push(operation(operands.pop(),operands.pop(),operator.pop()));
			}
	        System.out.println("Ans is "+operands.pop());
		}
		
	}
	
}
//-5+8*6
//(55+9)/9
//20+-3*5/8
//5+15/3*2-8/3
