package com.fzz.stack;


public class StackByLinkedList {
	public static void main(String[] args) {
		DoubleLinkedList linkedList=new DoubleLinkedList();
		linkedList.push(2);
		linkedList.push(5);
		linkedList.push(4);
		System.out.println(linkedList.pop());
		
		linkedList.show();
	}
}

class Node{
	int no;
	Node front;
	Node next;
	public Node(int no){
		this.no=no;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + "]";
	}
	
	
	
}

class DoubleLinkedList{
	private Node head=new Node(0);
	Node temp=head;
	
	public boolean isEmpty(Node head){
		return head.next==null;
	}
	
	
	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}


	//��ջ
	public void push(int value){
		Node node=new Node(value);
		temp.next=node;
		node.front=temp;
		temp=node;
	}
	
	//��ջ
	public int pop(){
		if(isEmpty(head)){
			throw new RuntimeException("ջ�ѿ�");
		}
		Node node=temp;
		temp=temp.front;
		temp.next=null;
		return node.no;
	}
	
	//չʾջ
	public void show(){
		if(isEmpty(head)){
			System.out.println("ջ�ѿ�");
		}
		Node cur=temp;
		while(cur!=head){
			System.out.println(cur);
			cur=cur.front;
		}
	}
}
