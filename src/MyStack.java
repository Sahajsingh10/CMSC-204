
//@author Sahaj Singh
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {

	int size;
	ArrayList<T> array;

	public MyStack() {
		array = new ArrayList<>();
		size = 1000;

	}

	public MyStack(int size) {
		this.size = size;

		array = new ArrayList<T>(size);
	}

	public boolean isEmpty() {
		if (array.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean isFull() {
		boolean isFull = false;

		if (array.size() == size) {
			isFull = true;
		}

		return isFull;
	}

	@Override
	public T pop() throws StackUnderflowException {
		T lastElement = null;
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			lastElement = array.get(array.size() - 1);
			array.remove(array.size() - 1);
		}
		return lastElement;
	}

	@Override
	public T top() throws StackUnderflowException {
		T topStackElement = null;
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			topStackElement = array.get(array.size() - 1);

		}
		return topStackElement;
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		boolean isadded = false;
		if (isFull()) {
			throw new StackOverflowException();
		} else {
			array.add(e);
			isadded = true;

		}
		return isadded;
	}

	public String toString() {
		String data = "";
		for (int i = 0; i < array.size(); i++) {
			data += array.get(i);
		}
		return data;

	}

	@Override
	public String toString(String delimiter) {
		String data = "";
		for (int i = 0; i < array.size(); i++) {
			if (i < array.size() - 1) {

				data += array.get(i) + delimiter;
			} else {
				data += array.get(i);
			}

		}
		return data;

	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> list1 = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			list1.add(list.get(i));
		}

		for (int i = 0; i < list1.size(); i++) {
			try {
				push(list1.get(i));
			} catch (StackOverflowException e) {

				e.printStackTrace();
			}
		}

	}

}
