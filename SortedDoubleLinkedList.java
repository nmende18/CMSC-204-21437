package application;
/*
 * @Author Napoleon Mendez
 * Assignment 3 implementation
 * CMSC-204 CRN-21437
 */
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comparator;
	
	/*
	 * @param compareableObject the comparator used for sort the elements.
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> compareableObject) {
		this.comparator = compareableObject;
	}
	
	/*
	 * Adds a new element to the list in a sorted position.
	 * @param data is the element to be added.
	 */
	public void add(T data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			Node currentHead = head;
			
			while(currentHead != null && comparator.compare(data, currentHead.dataNode) > 0) {
				currentHead = currentHead.next;
			}
			// Insert at the end if element was not found
			if(currentHead == null) {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			// Insert at the front if the new element is smaller than the head
			else if(currentHead == head) {
				node.next = head;
				head.prev = node;
				head = node;
			}
			else {
				// Insert in the middle
				node.prev = currentHead.prev;
				node.next = currentHead;
				currentHead.prev.next = node;
				currentHead.prev = node;
			}
		}
		size++;
	}
	
	
	/*
	 * @param data the element to add to the end
	 * @throws UnsuportedOperationException 
	 */
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/*
	 * @param data the element to add to the front
	 * @throws UnsupportedOperationException
	 */
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/*
	 * Returns a listIterator for the element in the list
	 * @return a ListIterator for the list
	 */
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/*
	 * Removes the first instance of the element in the list
	 * @param data the element to be removed
	 * @param comparator to compare the element
	 * @return the removed Node
	 */
	@Override
	public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}
	
}
