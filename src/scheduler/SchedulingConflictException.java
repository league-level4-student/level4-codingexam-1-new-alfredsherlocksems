package scheduler;

public class SchedulingConflictException extends Exception{
	
	public static void checkDoubleBooking(Node<Event> checker, Node<Event> node) throws SchedulingConflictException {
		if (node == checker) {
			throw new SchedulingConflictException();
		}
	}
}
