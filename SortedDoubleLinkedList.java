
//@author Sahaj Singh
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> compareableObject = null;

	public SortedDoubleLinkedList(Comparator<T> compareableObject) {

		this.compareableObject = compareableObject;

	}

	@SuppressWarnings("unchecked")
	public SortedDoubleLinkedList<T> add(T data) {

		Node<T> current = head;
		Node <T> last  = tail;
		Node<T> newNode = new Node<T>(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		else if (compareableObject.compare(data, (T) head.data) <= -1) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else if (compareableObject.compare(data, (T) tail.data) >= 1) {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		} else {
			 current = head.next;
			while (current.next != null && compareableObject.compare(data, current.data) >= 1) {
				current = current.next;
			}
			newNode.next = current;
			newNode.prev = current.prev;
			current.prev.next = newNode;
			current.prev = newNode;
		}
		size++;
		return this;

	}

		

	

	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}

	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}

	@SuppressWarnings("unchecked")
	public ListIterator<T> iterator() {

		return (ListIterator<T>) super.iterator();

		

	}

	@SuppressWarnings("rawtypes")
	public SortedDoubleLinkedList<T> remove​(T data, Comparator<T> comparator) {
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
		

	}

}
