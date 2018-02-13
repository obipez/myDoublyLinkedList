package myDoublyLinkedList;

//	import java.util.Scanner;

	public class myDoublyLinkedList<E> {
		Node head;
		Node tail;
		
		public static void main(String[] args) {
			myDoublyLinkedList<String> whatever = new myDoublyLinkedList<String>();

			System.out.println("Let's modify the list!");
			whatever.addFirst("Molly");
			whatever.addFirst("Bongos");
			whatever.addFirst("Ivan");
			whatever.addFirst("3");
			whatever.addFirst("Yoyo");
			whatever.traverseForward();
			System.out.println();


//			Scanner scan = new Scanner(System.in);
//			System.out.println("Enter a command: addFirst, addThis, addLast, removeFirst, removeLast, removeThis, Change, Exit.");
//			boolean running = true;
//			while(running) {
//				boolean empty = false;
//				switch(scan.nextLine().trim()) {
//				case "removeFirst":
//					whatever.removeFirst();
//					System.out.println("Successfully removed!" + "\n");
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "addFirst":
//					System.out.println("Please enter item for the list.");
//					String command = scan.nextLine().trim();
//					whatever.addFirst(command);
//					System.out.println("Addition Successful!\n");
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "addThis":
//					System.out.println("Please input an item and number for the list!");
//					String command1 = scan.nextLine().trim();
//					int index = scan.nextInt();
//					whatever.addThis(command1, index);
//					if(index < 0 || index > whatever.size()) {
//						System.out.println("Invalid input.\n");
//					}
//					else {
//						System.out.println("Addition successful!\n");
//					}
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "addLast":
//					System.out.println("Please enter item for the list.");
//					String command2 = scan.nextLine().trim();
//					whatever.addLast(command2);
//					System.out.println();
//					System.out.println("Successfully Removed!" + "\n");
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "removeLast":
//					whatever.removeLast();
//					System.out.println("Successfully removed!\n");
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "removeThis":
//					System.out.println("Please input the index you want removed.");
//					int index1 = scan.nextInt();
//					whatever.removeThis(index1);
//					System.out.println();
//					if(index1 < 0 || index1 > whatever.size()) {
//						System.out.println("Invalid input.\n");
//					}
//					else {
//						System.out.println("Successfully Removed!\n");
//					}
//					System.out.println("Here's the list now:");
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "Change":
//					System.out.println("Please input your new item and then index to change within the list!");
//					String command3 = scan.nextLine().trim();
//					int index2 = scan.nextInt();
//					whatever.changeData(command3, index2);
//					if(index2 < 0 || index2 > whatever.size()) {
//						System.out.println("Invalid input.\n");
//					}
//					else {
//						System.out.println("Item successfully changed!\n");
//					}
//					whatever.traverse();
//					System.out.println();
//					break;
//				case "Exit":
//					System.out.print("Exiting program.\n");
//					running = false;
//					break;
//				case "":
//					empty= true;
//					break;
//				default:
//					System.out.println();
//					System.out.println("Command not recognized!\n");
//					break;
//				}
//				if(empty != true && running != false) {
//					System.out.println("Please enter a command: addFirst, addThis, addLast, removeFirst, removeLast, removeThis, Change, Exit");
//				}
//			}
//			scan.close();
		}

		public class Node {
			E data; 
			Node next;
			Node prev;
			
			public Node() {
				data = null;
				next = null;
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

//		public void traverse() {
//			Node current = head.next;
//			while(current.next != null) {
//				System.out.println(current.data);
//				current = current.next;
//			}
//			System.out.println(current.data);
//		}
		
		
	//Assuming that traverse code from before is same as going forward
		public void traverseForward() {
			Node current = head.next;
			while(current.next != null) {
				System.out.println(current.data);
				current = current.next;
			}
			System.out.println(current.data);
		}

		public void traverseBackward() {
			Node tail = null;
			Node current = head;
			
			while(current != null) {
				System.out.println(current.data);
				tail = current.prev;
				current.prev = current.next;
				current.next = tail;
				current = current.prev;
			}
			if(tail != null) {
				head = tail.prev;
			}
			
		}
		
		public void addFirst(E new_data) {
			Node new_node = new Node();
			new_node.data = new_data;
			if(head == null) {
				new_node.next = head;
				new_node.prev = null;
				return;
			}
			new_node.next = head.next;
			head.next = new_node;
			if(head != null) {
				head.prev = new_node;
				head = new_node;
			}
			}
		

		public void addThis(E new_data, int index) {
			if(index < 0 || index > size()) {
				return;
			}
			Node new_node = new Node();
			new_node.next = head;

			Node current = new_node;
			if(index == 0) {
				addFirst(new_data);
			}
			else if(index == size()) {
				addLast(new_data);
			}
			else {
			for (int i = 0; i < index; ++i) {
				current = current.next;
			}

			Node node = new Node();
			node.data = new_data;
			node.next = current.next;
			current.next = node;

			return;
			}
		}

		public void addLast(E new_data) {
			Node new_node = new Node();
			new_node.data = new_data;
			if(head == null) {
				head = new Node();
				new_node.data = new_data;
				return;
			}
			new_node.next = null;
			Node last = tail;				//changed Node last = head; to tail. Makes a diff???
			while(last.next != null)
				last = last.next;
			last.next = new_node;
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
	}
