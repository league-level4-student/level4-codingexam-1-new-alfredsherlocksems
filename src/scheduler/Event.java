package scheduler;

public class Event {
	String name;
	int time;
	public Event(int time, String name) {
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	
	public int getTime() {
		return time;
	}
	public void setName(String thing) {
		name = thing;
	}
	public void setTime(int value) {
		time = value;
	}
}
