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
//		System.out.println("Here is the data:" + head.data);
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
//		System.out.println(current.data);
	}
	
	
	public void traverseBackward() {
//		System.out.println("Here is the data:" + head.data);
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
		if(index < 0 || index > size()) {
			System.out.println("Invalid");
			return;
		}
		Node new_node = new Node();
		new_node.data = new_data;
		new_node.next = null;

		if(index == 0) {
			addFirst(new_data);
		}else if(index == size()){
			addLast(new_data);
		}else {
			Node current = head;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			new_node.prev = current;
			new_node.next = current.next;
			current.next.prev = new_node;
			current.next = new_node;
		}
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
		head.next.prev = null;
		head = head.next;
		current.next = null;
	}
	
	public void removeLast() {
		Node current = tail;
		current.prev.next = null;
		tail = tail.prev;
		current.prev = null;
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

		Node current = head.next;
		int counter = 1;
		while(counter != index){
			current = current.next;
			counter++;
		}
		current.data = new_data;
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

		System.out.println("addFirst, addLast, and traverseForward");
		whatever.addFirst("Molly");
		whatever.addFirst("Bongos");
		whatever.addFirst("Ivan");
		whatever.addFirst("3");
		whatever.addFirst("Yoyo");
		whatever.addLast("Clarence");
		whatever.traverseForward();
		System.out.println();

		System.out.println("removeThis");
		whatever.removeThis(2);
		whatever.traverseForward();
		System.out.println();
		
		System.out.println("removeFirst and addThis");
		whatever.removeFirst();
		whatever.addThis("Cats", 3);
		whatever.traverseForward();
		System.out.println();

		System.out.println("removeLast and changeData");
		whatever.removeLast();
		whatever.changeData("Fishies", 3);
		whatever.traverseForward();
		System.out.println();

		System.out.println("traverseBackward");
		whatever.traverseBackward();
		System.out.println();
	}
}
