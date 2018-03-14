package org.ohjic.mem.web;

public class Main {

  public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		int number = 10;
		
		for(int i=1; i<= number; i++) {
			list.add(i);	
		}
		
		System.out.println(list.size());
		
		System.out.println(list.print());
		
		list.reverse();
		
//		list.print();
  }
	
	
	
}


class LinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
	
		private Object data;
		private Node next;


		public Node(Object data) {
			this.data = data;	
			this.next = null;
		}

	}
	
	public void add(Object data) {
		
		Node node = new Node(data);
		
		if(this.size == 0) {
			
			this.head = node;
			node.next = head;
			
			this.head= node;
			this.tail= head;
			
			size++;	
			
			if(head.next == null) {
				this.tail = this.head;
			}
			
		}else {
			
			this.tail.next = node;
			this.tail = node;

			size++;

			
		}

		System.out.println("s: " + size);
	}
	
	public int size() {
		return this.size;
	}
	
	public void remove(int index) {
		System.out.println(index +"가 삭제되었습니다.");
	}
	
	public void reverse() {
		System.out.println("역순 정렬");
	}
	
	public String print() {
		
		String result = "";
				
		if(this.head == null) {
			//return "";
		}
		
		Node tempNode = this.head;
		
		while(tempNode.next != null) {
			System.out.println(tempNode.data);
			result += String.valueOf(tempNode.data) + " ";
			tempNode = tempNode.next;
		}
		System.out.println("res;ult: " + result);
		return result;
	}
}



