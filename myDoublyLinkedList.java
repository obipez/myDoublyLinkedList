public class myDoublyLinkedList<E> {
	Node head;
	Node tail;
	
	myDoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	public class Node {
		E data; 
		Node next;
		Node prev;

		public Node() {
			data = null;
			next = null;
			prev = null;
		}


		public Node(E newData, int index) {
			Node current = head;
			int counter = 1;
			while(counter-1 != index) {
				current = current.next;
				counter++;
			}
			data = newData;
			this.next = current.next;
			head.next.prev = this;
			current.next = this;
			this.prev = current;
			current.next = this;
		}
	}

	public void traverseForward() {
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
//		System.out.println(current.data);
	}
	
	
	public void traverseBackward() {
		Node current = tail.prev;
		while(current.prev != null) {
			System.out.println(current.data);
			current = current.prev;
		}
//		System.out.println(current.data);
	}

	public void addFirst(E new_data) {
		Node new_node = new Node();
		new_node.data = new_data;

		new_node.next = head.next;
		head.next.prev = new_node;
		head.next = new_node;
		new_node.prev = head;
	}

	public void addThis(E new_data, int index) {
		Node new_node = new Node(new_data, index);
	}

	public void addLast(E new_data) {
		Node new_node = new Node();
		new_node.data = new_data;

		new_node.prev = tail.prev;
		tail.prev.next = new_node;
		tail.prev = new_node;
		new_node.next = tail;
	}

	public void removeFirst() {
		Node current = head;
		head = head.next;
		current.next = null;
//		if(head == null) {
//			return;
//		}
//		if (head != null) {
//			head = head.next;
//		}
	}

	public void removeLast() {
		if(tail == null) {
			return;
		}
		if (tail != null) {
			tail = tail.prev;
		}
	}

	public void removeThis(int index) {		
		Node current = head;
		int counter = 1;
		while(counter-1 != index) {
			counter++;
			current = current.next;
		}
//		System.out.println("This is: " + current.data);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = null;
		current.prev = null;
	}

	public void changeData(E new_data, int index) {
		Node new_node = new Node(new_data, index);
		Node current = new_node;
		current = current.next;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = null;
		current.prev = null;
		
		
//		Node current = head;
//		int counter = 1;
//		while(counter-1 != index) {
//			current = current.next;
//			counter++;
//		}
//		data = newData;
//		this.next = current.next;
//		head.next.prev = this;
//		current.next = this;
//		this.prev = current;
//		current.next = this;
		
	}

//	public int size() {
//		int counter = 1;
//		if(head.next == null) {
//			return counter;
//		}
//		Node current = head.next;
//		while(current != null) {
//			current = current.next;
//			counter++;
//		}
//		return counter;
//	}

//	public int getSize() {
//		Node temp = head.next;
//		int count = 1;
//		while(temp.next.data != null) {
//			count++;
//			temp = temp.next;
//		}
//		return count;
//	}
	
	public static void main(String[] args) {
		myDoublyLinkedList<String> whatever = new myDoublyLinkedList<String>();

		whatever.addFirst("Molly");
		whatever.addFirst("Bongos");
		whatever.addFirst("Ivan");
		whatever.addFirst("3");
		whatever.addFirst("Yoyo");
		whatever.addLast("Clarence");
		whatever.traverseForward();
		System.out.println();

		whatever.removeThis(2);
		whatever.traverseForward();
		System.out.println();
		
		whatever.removeFirst();
		whatever.addThis("Cats", 3);
		whatever.traverseForward();
		System.out.println();

		whatever.changeData("Fishies", 3);
//		whatever.removeLast();
//		whatever.traverseForward();
//		System.out.println();
				
//		whatever.removeFirst();
//		whatever.removeLast();
//		whatever.traverseBackward();
		whatever.traverseForward();
		System.out.println();
	}
}
