package scheduler;

public class Day {
	LinkedList<Event> events = new LinkedList<Event>();
	Node<Event> node = events.getHead();
	public void newEvent(int time, String name) {
		Event event = new Event(time, name);
		node = events.getHead();
	}
}
