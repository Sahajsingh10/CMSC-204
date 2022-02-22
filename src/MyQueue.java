
//@author Sahaj Singh
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {

	int size;
	ArrayList<T> array;

	public MyQueue() {

		array = new ArrayList<>();
		size = 1000;

	}

	public MyQueue(int size) {

		this.size = size;
		array = new ArrayList<>(size);

	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public boolean isFull() {
		if (array.size() == size) {
			return true;
		}
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T dataFront;
		if (!(isEmpty())) {
			dataFront = array.get(0);
			array.remove(0);
			return dataFront;
		} else {
			throw new QueueUnderflowException();
		}

	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		boolean queued = false;
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			array.add(e);
			queued = true;
		}
		return queued;
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
				enqueue(list1.get(i));
			} catch (QueueOverflowException e) {

				e.printStackTrace();
			}
		}

	}

}
