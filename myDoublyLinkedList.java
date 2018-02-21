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
			}
			data = newData;
			this.next = current.next;
			current.next = this;
		}
	}

//			public void traverse() {
//				Node current = head.next;
//				while(current.next != null) {
//					System.out.println(current.data);
//					current = current.next;
//				}
//				System.out.println(current.data);
//			}

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
		while(current.prev.data != null) {
			System.out.println(current.data);
			current = current.prev;
		}
		System.out.println(current.data);
	}

	public void addFirst(E new_data) {
		Node new_node = new Node();
		new_node.data = new_data;
//		if(head.next.data != null) {
////			head.prev = new_node;
//			
//			head = new_node;
//		}
//		if(tail == null) {
//			new_node.next = tail;
//			new_node.prev = null;
//			return;
//		}
		new_node.next = head.next;
		head.next.prev = new_node;
		head.next = new_node;
		new_node.prev = head;
	}


	public void addThis(E new_data, int index) {
		Node new_node = new Node(new_data, index);
//		if(index < 0 || index > size()) {
//			return;
//		}
//		Node new_node = new Node();
//		new_node.next = head;
//
//		Node current = new_node;
//		if(index == 0) {
//			addFirst(new_data);
//		}
//		else if(index == size()) {
//			addLast(new_data);
//		}
//		else {
//			for (int i = 0; i < index; ++i) {
//				current = current.next;
//			}
//
//			Node node = new Node();
//			node.data = new_data;
//			node.next = current.next;
//			current.next = node;
//
//			return;
//		}
	}

	public void addLast(E new_data) {
		Node new_node = new Node();
		new_node.data = new_data;
//		if(head == null) {
//			head = new Node();
//			new_node.data = new_data;
//			return;
//		}
//		new_node.next = null;
//		Node last = tail;				//changed Node last = head; to tail. Makes a diff???
//		while(last.next != null)
//			last = last.next;
//		last.next = new_node;
//		
//		new_node.next = head.next;
//		head.next.prev = new_node;
//		head.next = new_node;
//		new_node.prev = head;
		
		new_node.prev = tail.prev;
		tail.prev.next = new_node;
		tail.prev = new_node;
		new_node.next = tail;
	}

	public void removeFirst() {
		if(head == null) {
			return;
		}
		if (head != null) {
			head = head.next;
		}
	}

	public void removeLast() {
		Node last = head;
		Node penultimate = null;
		while(last.next != null) {
			penultimate = last;
			last = last.next;
		}
		penultimate.next = null;
	}

	public void removeThis(int index) {
		if(index < 0 || index > size()) {
			return;
		}
		if(index == 0) {
			removeFirst();
		}
		else if(index == size()) {
			removeThis(index);
		}
		else {
			Node temp = head, prev = null;
			for(int i = 0; i < index -1; i++) {
				temp = temp.next;
			}
			prev = temp.next;
			temp.next = prev.next;
			prev = null;

		}
	}

	public void changeData(E item, int index) {

		Node new_node = head;							
		Node prev = null;								
		while (new_node != null && index >= 0) {
			index--;
			prev = new_node;
			new_node = new_node.next;
		}												
		if (prev != null)
			prev.data = item;
	}

	public int size() {
		if(head.next == null) {
			return 0;
		}
		int counter = 1;
		Node current = head.next;
		while(current.next != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}

	public static void main(String[] args) {
		myDoublyLinkedList<String> whatever = new myDoublyLinkedList<String>();

//		whatever.addFirst("Molly");
//		whatever.addFirst("Bongos");
//		whatever.addFirst("Ivan");
//		whatever.addFirst("3");
//		whatever.addFirst("Yoyo");
//		whatever.addLast("Clarence");
//		whatever.traverseForward();
//		System.out.println();
//		whatever.removeThis(2);
//		whatever.traverseForward();
//		System.out.println();
		whatever.addThis("Ryan", 3);
		whatever.addLast("Timmy");
//		whatever.removeFirst();
		whatever.traverseForward();
		System.out.println();
//		whatever.removeLast();
//		whatever.traverseBackward();
		//whatever.traverseBackward();
		System.out.println();
	}
}
