class LinkedList{

	private class Node{
		Node next;
		int data;
	}
	Node head;
	Node tail;
	int size;


	public void addFirst(int item)
	{
		Node nn = new Node();
		nn.data = item;
		if(size == 0)
		{
			this.head = nn;
			this.head.next = null;
			this.tail = this.head;
			
		}else{
			nn.next = this.head;
			this.head = nn;
		}
		size++;	
	}

	public void addLast(int item)
	{
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if(size == 0)
		{
			this.head = nn;
			this.tail = this.head;
			
		}else{
			this.tail.next = nn;
			this.tail = nn;
		}
		size++;
	}

	public int getFirst()
	{
		try{
			if(size == 0)
				throw new Exception();			
		}catch(Exception e)
		{
			System.out.println("LinkedList is Empty!!!!");
		}

		return this.head.data;
	}
	public int getLast()
	{
		try{
			if(size == 0)
				throw new Exception();			
		}catch(Exception e)
		{
			System.out.println("LinkedList is Empty!!!!");
		}

		return this.tail.data;
	}

	public int removeFirst()
	{
		try{
			if(size == 0)
				throw new Exception();			
		}catch(Exception e)
		{
			System.out.println("LinkeList is Empty!!!!");
		}

		int rev = this.head.data;

		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
		}else{
			this.head = this.head.next;

		}
		size--;

		return rev;
	}

		public int removeLast()
	{
		try{
			if(size == 0)
				throw new Exception();			
		}catch(Exception e)
		{
			System.out.println("LinkedList is Empty!!!!");
		}

		int rev = this.tail.data;

		if(this.size == 1)
		{
			this.head = null;
			this.tail = null;
		}else{
			Node nm1 = getNodeAt(this.size-2);
			 this.tail = nm1;
			 this.tail.next = null; 
		}
		size--;
		return rev;
	}	

	public void addAt(int idx, int item)
	{
		try{
			if(idx < 0 || idx > size)
				throw new Exception();
		}catch(Exception e)
		{
			System.out.println("Invalid Index");
		}

		Node nn = new Node();
		nn.data = item;
		if(idx == 0)
			addFirst(item);
		else if(idx == size)
			addLast(item);
		else{
			Node nm1 = getNodeAt(idx-1);
			Node np1 = getNodeAt(idx);
			nm1.next = nn;
			nn.next = np1;
			size++;
		}
	}

	

	public Node getNodeAt(int idx)
	{
		Node temp = this.head;
		try{
			if(idx < 0 || idx >= size)
				throw new Exception();
		}catch(Exception e)
		{
			System.out.println("Invalid Index");
		}

			for(int i = 1; i <= idx; i++)
			{
				temp = temp.next;
			}
		return temp;
	}


	public int getAt(int idx)
	{
		Node temp = this.head;
		try{
			if(idx < 0 || idx >= size)
				throw new Exception();
		}catch(Exception e)
		{
			System.out.println("Invalid Index");
		}

			for(int i = 1; i <= idx; i++)
			{
				temp = temp.next;
			}
		return temp.data;
	}


	public int removeAt(int idx)
	{
		try{
			if(size == 0)
			throw new Exception();
		}catch(Exception e){
			System.out.println("LinkedList is Empty!!!");
		}

		try{
			if(idx < 0 || idx >= size)
				throw new Exception();
		}catch(Exception e)
		{
			System.out.println("Invalid Index");
		}

		int temp = 0;

		if(idx == 0)
			return removeFirst();
		else if(idx == size-1)
			return removeLast();
		else{
			Node nm1 = getNodeAt(idx - 1);
			Node n1 = getNodeAt(idx);

			nm1.next = n1.next;
			size--;

			return n1.data;
		}
	}


	public void display()
	{
		System.out.println("-----------------------------------------");
		System.out.println();
		Node temp = this.head;
		for(int i = 0; i < size; i++)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("-----------------------------------------");
	}


//Reverse data and not address
	public void reverseDisplay()
	{
		int left = 0;
		int right = this.size-1;

		while(left < right)
		{
			Node l = getNodeAt(left);
			Node r = getNodeAt(right);

			int temp = l.data;
			l.data = r.data;
			r.data = temp;

			left++;
			right--;
		}
	}

// Reverse address
	public void reversePointer()
	{
		Node prev = this.head;
		Node curr = prev.next;

		while(curr != null)
		{
			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead; 
		}

		this.tail = this.head;
		this.tail.next = null;
		this.head = prev;

	}


	public void reversePointerByRecursion(){
		reversePointerHelper(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null; 
	}

	public void reversePointerHelper(Node prev, Node curr)
	{
		if(curr == null)
		{
			return;
		}
		reversePointerHelper(curr, curr.next);
		curr.next = prev;
	}

	public void reverseDisplayRecursion()
	{
		reverseDisplayRecursionHelper(this.head, this.head, 0);
	}

	public Node reverseDisplayRecursionHelper(Node left, Node right, int s)
	{
		if(right == null)
		{
			return left;
		}

		left = reverseDisplayRecursionHelper(left, right.next, s+1);

		//swap
		if(s >= size/2)
		{
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}

		return left.next;

	}


	private class HeapMover{
		Node left = head;
	}

	public void reverseDRHeapMover()
	{
		reverseDRHeapMoverHelper(new HeapMover(), this.head, 0);
	}

	public void reverseDRHeapMoverHelper(HeapMover mover, Node right, int s)
	{
		if(right == null)
			return;

		reverseDRHeapMoverHelper(mover, right.next, s+1);

		if(s >= size/2)
		{
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;	
		}

		mover.left = mover.left.next;
	}


	public void fold()
	{
		foldHelper(new HeapMover(), this.head, 0);
	}

	private void foldHelper(HeapMover mover, Node right, int s)
	{
		if(right == null)
		{
			return;
		}

		foldHelper(mover, right.next, s+1);

		if(s > size/2)
		{
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;

			mover.left = ahead;
		}

		if(s == size/2)
		{
			this.tail = right;
			this.tail.next = null;
		}

	}
}



public class LinkedListClient{
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.display();

		// ll.reverseDisplay(); 
		// ll.reversePointer();
		// ll.reversePointerByRecursion();
		// ll.reverseDisplayRecursion();
		// ll.reverseDRHeapMover();
		ll.fold();
		ll.display();

	}
}