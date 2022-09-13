package com.fzz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PolandCalculate {
	public static void main(String[] args) {
//		String expression="1 2 3 + * 9 -";
//		List<String> list=putSuffixExpressionToList(expression);
//		int result=calculate(list);
//		System.out.printf("结果为："+result);

		String infixExpression="1+((2+3)*4)-5";
		List<String> infixList = putInfixExpressionToList(infixExpression);
		List<String> suffixList = infixListToSuffix(infixList);
		int result=calculate(suffixList);
		System.out.println(result);
	}

	//把中缀表达式集合转化为后缀表达式集合
	public static List<String> infixListToSuffix(List<String> infixList){
		Stack<String> s1=new Stack<>();
		List<String> s2=new ArrayList<>();
		for(String item:infixList){
			if(item.matches("\\d+")){
				s2.add(item);
			} else if(item.equals("(")){
				s1.push(item);
			} else if(item.equals(")")){
				while(!s1.peek().equals("(")){
					s2.add(s1.pop());
				}
				s1.pop();
			} else{
				if(s1.size()==0){
					s1.push(item);
				}else{
					while(priority(s1.peek())>=priority(item)){
						if(s1.peek().equals("(")){
							break;
						}
						s2.add(s1.pop());
						if(s1.size()==0){
							break;
						}
					}
					s1.push(item);

				}
			}
		}
		while(s1.size()!=0){
			s2.add(s1.pop());
		}
		return s2;
	}

	public static boolean isOper(int oper){
		return oper=='+'||oper=='-'||oper=='*'||oper=='/';
	}

	public static int priority(String oper){
		if(oper.equals("+")||oper.equals("-")){
			return 0;
		} else if(oper.equals("*")||oper.equals("/")){
			return 1;
		} else {
			return 0;
		}
	}

	//计算后缀表达式的结果
	public static int calculate(List<String> list){
		Stack<String> stack=new Stack<>();
		int num1=0;
		int num2=0;
		
		for(String item:list){
			if(item.matches("\\d+")){
				stack.push(item);
			}else{
				num1=Integer.parseInt(stack.pop());
				num2=Integer.parseInt(stack.pop());
				int res=0;
				if(item.equals("+")){
					res=num1+num2;
				}else if(item.equals("-")){
					res=num2-num1;
				}else if(item.equals("*")){
					res=num1*num2;
				}else if(item.equals("/")){
					res=num2/num1;
				}
				stack.push(res+"");
			}
		}
		return Integer.parseInt(stack.pop());
	}

	//把后缀表达式加入到list集合中
	public static List<String> putSuffixExpressionToList(String expression){
		String[] datas=expression.split(" ");
		List<String> list=new ArrayList<String>();
		for(String item:datas){
			list.add(item);
		}
		return list;
	}

	//把中缀表达式加入到list集合中
	public static List<String> putInfixExpressionToList(String infixExpression){
		List<String> list=new ArrayList<>();
		int index=0;
		char ch=' ';
		String keepNum="";
		while(true){
			ch=infixExpression.substring(index,index+1).charAt(0);
			if(isOper(ch)||ch=='('||ch==')'){
				list.add(ch+"");
			}else{
				keepNum+=ch;
				if(index==infixExpression.length()-1){
					list.add(keepNum);
				}else{
					char c=infixExpression.substring(index+1,index+2).charAt(0);
					if(isOper(c)||c=='('||c==')'){
						list.add(keepNum);
						keepNum="";
					}
				}
			}
			index++;
			if(index==infixExpression.length()){
				break;
			}
		}
		return list;


	}
	
	
}
