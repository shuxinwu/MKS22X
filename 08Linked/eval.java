import java.io.*;
import java.util.*;

public class eval{

    public static double eval(String exp){
	Stack<Double> stack = new Stack<Double>();
	for (int i = 0; i < exp.length(); i++){
	    int b = 0;

	    if (exp.charAt(i) == '+'){
	       	stack.push(stack.pop() + stack.pop());
		b = i + 1;
	    }

	    if (exp.charAt(i) == '-'){
	       	stack.push(-1 * (stack.pop() - stack.pop()));
		b = i + 1;
	    }

	    if (exp.charAt(i) == '*'){
	       	stack.push(stack.pop() * stack.pop());
		b = i + 1;
	    }

	    if (exp.charAt(i) == '/'){
	        double x = stack.pop();
		double y = stack.pop();
		stack.push(y / x);
		b = i + 1;
	    }

	    if (exp.charAt(i) == '%'){
		double x = stack.pop();
		double y = stack.pop();
		stack.push(y % x);
		b = i + 1;
	    }
	    
	    // sep by space
	    if (exp.charAt(i) == ' '){
		try{
		    stack.push(Integer.parseInt(exp.substring(b, i)) + 0.0);
		}
		catch(NumberFormatException e){
		    stack.push(Double.parseDouble(exp.substring(b, i)));
		}
		b = i + 1;
	    }
	    System.out.println(i);
	    System.out.println(b);
	    System.out.println(stack);
	}
	
	return stack.pop();
    }

    public static void main(String[] args){
       	System.out.println(eval("11 3 - 4 + 2.5 *"));

	/*
	eval("10 2.0 +") is 12.0
	    eval("11 3 - 4 + 2.5 *") is 30.0
	    eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
	*/
    }
}
