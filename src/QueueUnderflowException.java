//@author Sahaj Singh
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Queue is empty");
	}

}
