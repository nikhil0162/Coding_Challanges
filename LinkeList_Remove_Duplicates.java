import java.util.*;

//////// change the name to LinkedList before compile
class LinkedList_Remove_Duplicates {

	private class Node {

		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("linked list is empty");

		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("linked list is empty");

		return tail.data;
	}

	public void addLast(int item) {
		// create a new node
		Node nn = new Node();

		nn.data = item;
		nn.next = null;

		// update summary
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else

		{
			this.tail.next = nn;
			this.tail = nn;

			size++;
		}

	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			size++;
		}

	}

	public int removeFirst() throws Exception {
		Node fn = this.head;

		if (this.size == 0)
			throw new Exception("linked list is empty");

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			size = 0;
		} else {
			Node np1 = this.head.next;
			this.head = np1;
			size--;
		}

		return fn.data;
	}

	public void remove_duplicate() throws Exception {

		LinkedList ll = new LinkedList();
	    ll.addLast(this.head.data);
	    
	    this.removeFirst();
	    while(this.size != 0)
	    {
	        if(ll.tail.data != this.head.data)
	        {
	        	ll.addLast(this.removeFirst());
	        }else{
	        	this.removeFirst();
	        }
	    }

	    this.head = ll.head;
	    this.tail = ll.tail;

	}

	public void display() {

		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int t = scn.nextInt();

		for (int i = 0; i < t; i++) {
			LinkedList ll = new LinkedList();
			int n = scn.nextInt();
			for (int j = 0; j < n; j++) {
				int item = scn.nextInt();
				ll.addLast(item);
			}

			ll.remove_duplicate();
			ll.display();
			System.out.println();

		}
	}
}
