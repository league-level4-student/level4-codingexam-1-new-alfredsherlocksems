package scheduler;

public class Event {
	String day;
	int time;
	String name;
	public Event(int time, String day, String name) {
		this.day = day;
		this.time = time;
		this.name = name;
	}
	
	public String getDay() {
		return day;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDay(String thing) {
		day = thing;
	}
	public void setTime(int value) {
		time = value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
