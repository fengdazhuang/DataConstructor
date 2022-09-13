package com.fzz.linkedList;

import java.util.Stack;

class HeroNode{
	int no;
	String name;
	String nickName;
	HeroNode next;
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	
	
}

class LinkedList{
	private HeroNode head=new HeroNode(0, "", "");
	
	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}

	public void add(HeroNode node){
		HeroNode temp=head;
		while(true){
			if(temp.next==null){
				break;
			}
			temp=temp.next;
		}
		temp.next=node;
		
	}
	
	public void delete(int no){
		if(head.next==null){
			System.out.println("链表为空,删除失败");
			return;
		}
		HeroNode temp=head;
		while(true){
			if(temp.next==null){
				System.out.println("未找到删除结点");
				break;
			}
			if(temp.next.no==no){
				temp.next=temp.next.next;
				break;
			}
			temp=temp.next;
		}
	}
	
	public void list(){
		if(head.next==null){
			System.out.println("链表为空");
		}
		HeroNode temp=head;
		
		while(temp.next!=null){
			temp=temp.next;
			System.out.println(temp);
		}
	}
	
	public void reverse(HeroNode head){
		if(head.next==null||head.next.next==null){
			return;
		}
		HeroNode temp=head.next;
		HeroNode next=null;
		HeroNode newHead=new HeroNode(0, "", "");
		
		while(temp!=null){
			next=temp.next;
			temp.next=newHead.next;
			newHead.next=temp;
			temp=next;
		}
		head.next=newHead.next;
	}
	
	public HeroNode getBackHeroNode(HeroNode head,int index){
		if(head.next==null){
			System.out.println("链表为空");
			return null;
		}
		int size=getLength(head);
		if(index<=0||size-index<0){
			System.out.println("不存在该索引的结点");
			return null;
		}
		HeroNode temp=head.next;
		for(int i=0;i<size-index;i++){
			temp=temp.next;
		}
		return temp;
		
	}
	
	public int getLength(HeroNode head){
		if(head.next==null){
			return 0;
		}
		HeroNode temp=head.next;
		int cur=0;
		while(temp!=null){
			temp=temp.next;
			cur++;
		}
		return cur;
	}
	
	//从头到尾打印单链表
	public void printFromBackToFront(HeroNode head){
		if(head.next==null){
			return ;
		}
		HeroNode temp=head.next;
		Stack<HeroNode> stack=new Stack<>();
		while(temp!=null){
			stack.add(temp);
			temp=temp.next;
		}
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
	
}

public class SingleLinkedList {
	public static void main(String[] args) {
		
		HeroNode node1=new HeroNode(1, "a", "aaa");
		HeroNode node2=new HeroNode(2, "b", "bbb");
		HeroNode node3=new HeroNode(3, "c", "ccc");
		HeroNode node4=new HeroNode(4, "d", "ddd");
		HeroNode node5=new HeroNode(5, "e", "eee");
		
		LinkedList linkedList=new LinkedList();
		linkedList.add(node1);
		linkedList.add(node2);
		linkedList.add(node3);
		linkedList.add(node4);
		linkedList.add(node5);
		
		linkedList.list();
		linkedList.delete(3);
		System.out.println("---------");
		linkedList.list();
		
		System.out.println("倒数第2个结点为："+linkedList.getBackHeroNode(linkedList.getHead(), 2));
		System.out.println("---------");	
		
//		linkedList.reverse(linkedList.getHead());
//		linkedList.list();
		
		linkedList.printFromBackToFront(linkedList.getHead());
		
	}
	
	
	
}
