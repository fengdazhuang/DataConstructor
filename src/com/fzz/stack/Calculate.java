package com.fzz.stack;


import java.util.Stack;

public class Calculate {

	public static void main(String[] args) {
		
		String string="20+3*4-13";
		Stack<Integer> numStack=new Stack<>();
		Stack<Character> operStack=new Stack<>();
		int index=0;
		char ch=' ';
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;
		String keepNum="";
		while(true){
			ch=string.substring(index, index+1).charAt(0);
			
			if(isOper(ch)){
				if(operStack.size()==0){
					operStack.push(ch);
				}else{
					if(priority(ch)<=priority(operStack.peek())){
						num1=numStack.pop();
						num2=numStack.pop();
						oper=operStack.pop();
						res=result(num1,num2,oper );
						numStack.push(res);
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
					
				}
			} else{
				keepNum+=ch;
				
				if(index==string.length()-1){
					numStack.push(Integer.parseInt(keepNum));
				}else{
					if(isOper(string.substring(index+1,index+2).charAt(0))){
						numStack.push(Integer.parseInt(keepNum));
						keepNum="";
					}
				}
				
			}
			
			index++;
			if(index>=string.length()){
				break;
			}
		}
		while(true){
			if(operStack.size()==0){
				break;
			}
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=result(num1,num2, oper);
			numStack.push(res);
		}
		int finalResult=numStack.pop();
		System.out.println("表达式的计算结果为："+finalResult);
		
	}
	
	public static int priority(int oper){
		if(oper=='*'||oper=='/') {
			return 1;
		} else if (oper=='+'||oper=='-') {
			return 0;
		} else{
			return -1;
		}
	}
	
	public static boolean isOper(char ch){
		return ch=='+'||ch=='-'||ch=='*'||ch=='/';
	}
	
	public static int result(int num1,int num2,int oper){
		int result = 0;
		switch (oper) {
		case '+':
			result=num1+num2;
			break;
		case '-':
			result=num2-num1;
			break;
		case '*':
			result=num1*num2;
			break;
		case '/':
			result=num2/num1;
			break;
		default:
			break;
		}
		return result;
	}
	
}
