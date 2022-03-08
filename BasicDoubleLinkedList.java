//@author Sahaj Singh
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class BasicDoubleLinkedList<T> implements Iterable {

	int size;
	Node head;
	Node tail;

	public BasicDoubleLinkedList() {

	}

	public BasicDoubleLinkedList(Node head, Node tail) {

		head = null;
		tail = null;
		size = 0;

	}

	public class Node<T> {

		T data;
		Node prev;
		Node next;

		public Node(T dataNode) {
			data = dataNode;

		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		

	}

	public void addToEnd(T data) {

		Node newNode = new Node(data);
		Node<T> prevtail = null;
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			prevtail = tail;
			tail = newNode;
			newNode.prev = prevtail;
			prevtail.next = newNode;
			
		}
	
		size++;
	}

	public void addToFront(T data) {

		Node newNode = new Node(data);
		Node<T> prevhead = null;
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			prevhead = head;
			head = newNode;
			newNode.next = prevhead;
			prevhead.prev = newNode;
			
		}	
		size++;
	}

	@SuppressWarnings("unchecked")
	public T getFirst() {
		return (T) head.getData();

	}

	@SuppressWarnings("unchecked")
	public T getLast() {
		return (T) tail.getData();

	}

	public T retrieveFirstElement() {

		T data = (T) head.getData();
		head = head.next;
		head.prev = null;
		size--;
		return data;

	}

	public ArrayList<T> toArrayList() {
		ArrayList<T> list1 = new ArrayList<T>(size);

		Node<T> current = head;

		while (true) {
			if (current == null) {
				break;
			}
			list1.add(current.data);
			current = current.next;
		}
		return list1;
	}

	public T retrieveLastElement() {

		T data = (T) tail.getData();
		tail = tail.prev;
		tail.next = null;
		size--;
		return data;
	}

	public Iterator<T> iterator() {
		DoubleLinkedListIterator<T> iterate = new DoubleLinkedListIterator<T>();

		return iterate;
	}

	@SuppressWarnings("unchecked")
	public BasicDoubleLinkedList<T>remove(T targetData, java.util.Comparator<T> comparator) {
		Node<T> current = head;
		
		while (current != null) {
			
			if (comparator.compare((T) current.data, targetData) == 0) {
				
				if (current == tail) {
					tail = tail.prev;
					tail.next = null;
					size--;
					break;
				}
				else if (current == head) {
					head = head.next;
					head.prev = null;
					size--;
					break;
				}
				else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
					size--;
					break;
				}
			}
			current = current.next;
		}
		return this;
}

	public int getSize() {
		return size;
	}

	public class DoubleLinkedListIterator<T> implements ListIterator<T> {
		Node<T> current;
		Node<T> last;
		private int index;

		public DoubleLinkedListIterator() {
			current = head;
			last = tail;
			

		}

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() throws NoSuchElementException {
			T data = null;

			if (hasNext()) {
				data = (T) current.getData();
				current = current.next;
				index++;

			} else {
				throw new NoSuchElementException();
			}
			return data;

		}

		@Override
		public boolean hasPrevious() {

			return index > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T previous() throws NoSuchElementException {
			T data = null;
			if (hasPrevious()) {
				data = (T) last.getData();
				last = last.prev;
				index--;

			} else {
				throw new NoSuchElementException();
			} 
			return data;

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
		public void set(T e) {
			throw new UnsupportedOperationException();

		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();

		}

	}
}
