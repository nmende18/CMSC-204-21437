package application;

/*
 * @Author Napoleon Mendez
 * Assignment 3 implementation
 * CMSC-204 CRN-21437
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	/*
	 * A private inner class for the Node
	 */
	 class Node{
		protected T dataNode;
		protected Node prev;
		protected Node next;
		
		public Node(T dataNode) {
			this.dataNode = dataNode;
			prev = null;
			next = null;
		}
	}
	
	/*
	 * A listIterator that go through the elements of the list
	 * @return A listIterator
	 */
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	/*
	 * A private inner class that implementsListIterator
	 */
	private class DoubleLinkedListIterator implements ListIterator<T>{
		
		private Node currentHead;
		private Node currentTail;
		
		/*
		 * Constructor the the iterator
		 */
		public DoubleLinkedListIterator() {
			currentHead = head;
			currentTail = null;
		}

		/*
		 * Checks if there is a element next in the list
		 * @return true if there is a element next to one
		 */
		
		@Override 
		public boolean hasNext() {
			if(currentHead != null) {
				return true;
			}
			else {
				return false;
			}
		}
		
		/*
		 * Returns the next element in the list
		 * @return the next element of generic Type T
		 * @throws NoSuchElementException
		 */
		@Override
		public T next() throws NoSuchElementException{
			if(currentHead == null) {
				throw new NoSuchElementException();
			}
			else {
				currentTail = currentHead;
				T element = currentHead.dataNode;
				currentHead = currentHead.next;
				return element;
			}
		}

		/*
		 * Checks if there is a element previous in the list
		 * @return true if there is a element previous to one
		 */
		@Override
		public boolean hasPrevious() {
			if( (currentTail != null && currentTail.prev != null) || (currentHead != null && currentHead.prev != null)) {
				return true;
			}
			else {
				return false;
			}
		}

		/*
		 * Returns the previous element in the list
		 * @return the previous element of geenric Type T
		 * @throws NoSuchElementException
		 */
		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else if(currentHead == null) {
				currentHead = tail;
			}
			else if(currentTail != null && currentTail.prev != null) {
				currentHead = currentHead.prev;
			}
			else if(currentHead != null && currentHead.prev != null) {
				currentHead = currentHead.prev;
			}
			currentTail = currentHead;
			return currentHead.dataNode;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}
	
	/*
	 * Constructor to initialize the empty BasicDoubleLinkedList.
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	
	
	/*
	 * Returns the size
	 * @return the size of the list
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * Adds a new element to the end of the list
	 * @param T data is the data Type T to be added
	 */
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		if(tail != null) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		else {
			head = tail = newNode;
		}
		size++;
	}
	
	/*
	 * Adds a new element to the front of the list
	 * @param T data is the data tyype T to be added.
	 */
	public void addToFront(T data) {
		Node newNode = new Node(data);
		if(head != null) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else {
			head = tail = newNode;
		}
		size++;
	}
	
	/*
	 * Retrieves the first element in the list
	 * @return the first element of Type T
	 */
	public T getFirst() {
		if(head == null) {
			return null;
		}
		else {
			return head.dataNode;
		}
	}
	
	/*
	 * Retrieves the last element in the list
	 * @return the last element of Type T
	 */
	public T getLast() {
		if(tail == null) {
			return null;
		}
		else {
			return tail.dataNode;
		}
	}
	
	
	/*
	 * This method compare elements, and not using equals.
	 * @param targetData is the data element to be removed from the list
	 * @param comparator to use to compare the elements.
	 * @return the node having the targetData if found and removed or else null.
	 */
	
	public BasicDoubleLinkedList<T>.Node remove(T targetData, java.util.Comparator<T> comparator){

		Node currentHead = head;
		while(currentHead != null) {
			if(comparator.compare(currentHead.dataNode, targetData) == 0) {
				if(currentHead == head) {
					head = head.next;
					if(head != null) {
						head.prev = null;
					}else {
						tail = null;
					}
				}
			
				else if(currentHead == tail) {
					tail = tail.prev;
					if(tail != null) {
						tail.next = null;
					}else {
						head = null;
					}
				}
				else {
					currentHead.prev.next = currentHead.next;
					currentHead.next.prev = currentHead.prev;
				}
			
				size--;
				return currentHead;
		}
			currentHead = currentHead.next;
	}
		return null;
	}
	/*
	 * Retrieves and removes the first element
	 * @return the first element of Type T
	 */
	public T retrieveFirstElement() {
		if(head == null) {
			return null;
		}
		Node currentHead = head;
		
		head = head.next;
		
		if(head != null) {
			head.prev = null;
		}
		else {
			tail = null;
		}
		size--;
		return currentHead.dataNode;
	}
	
	/*
	 * Retrieves and removes the last element
	 * @return the last element of Type T
	 */
	public T retrieveLastElement() {
		if(tail == null) {
			return null;
		}
		Node currentTail = tail;
		tail = tail.prev;
		if(tail != null) {
			tail.next = null;
		}
		else {
			head = null;
		}
		size--;
		return currentTail.dataNode;
	}
	
	/*
	 * Convers the list to an ArrayList
	 * @return an ArrayList
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> arr = new ArrayList<>();
		Node temp = head;
		
		while(temp != null) {
			arr.add(temp.dataNode);
			temp = temp.next;
		}
		return arr;
		
	}

}