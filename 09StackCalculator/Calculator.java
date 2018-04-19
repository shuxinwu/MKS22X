import java.io.*;
import java.util.*;

public class Calculator{

    public static double eval(String exp){
	Stack<Double> stack = new Stack<Double>();
	// b tracks start of num to look at
	int b = 0;
	for (int i = 0; i < exp.length(); i++){
	   
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
		/*
		System.out.println("i: " + i);
		System.out.println("b: " + b);
		System.out.println("sub: " + exp.substring(b, i));
		*/
		if (i == b){
		    b++;
		}
		else{
		    if (exp.substring(b, i).indexOf('.') == -1){
			stack.push(Integer.parseInt(exp.substring(b, i)) + 0.0);
		    }
		    else{
			stack.push(Double.parseDouble(exp.substring(b, i)));
		    }
		    b = i + 1;
		}
	    }	    
	    //	    System.out.println(stack);
	}	
	return stack.pop();
    }

    public static void main(String[] args){
	//  	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	/*
	eval("10 2.0 +") is 12.0
	eval("11 3 - 4 + 2.5 *") is 30.0
	eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
	*/
    }
}
