package scheduler;

public class Event {
	String day;
	int time;
	public Event(int time, String day) {
		this.day = day;
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	
	public int getTime() {
		return time;
	}
	public void setDay(String thing) {
		day = thing;
	}
	public void setTime(int value) {
		time = value;
	}
}
