package scheduler;

import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables. 
 */
public class Scheduler {
	
	
	enum bob {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
		FRIDAY, SATURDAY, SUNDAY;
		
		LinkedList<Event> events;
		
		private bob () {
			events = new LinkedList<Event>();
		}
	}
	

	static bob[] days = bob.values();
	static boolean forever = true;
	
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	while (forever) {
    		
    		System.out.println("What would you like to do?");
    		String input = scanner.nextLine();
    		if(input.equals("add")) {
    			//ADD BUBBLE SORT TO ADD EVENT METHOD
    			addEvent(scanner);
    		}
    		else if(input.equals("view") ) {
    			System.out.println("Current events: ");
    			System.out.println();
    			for (int i = 0; i < days.length; i++) {
    				if (days[i].events.size() == 0) {
    					System.out.println("You have no events on " + days[i].name().toLowerCase());
    				}
    				else {
    					System.out.println("On " + days[i].name().toLowerCase() + " your event[s] are: ");
    				}
					Node<Event> node = days[i].events.getHead();
					while(node != null) {
						System.out.println("     You have " + node.getValue().getName() + " at " + node.getValue().getTime());
						node = node.getNext();
					}
				}
    		}
    		else if(input.equals("remove")) {
    			removeEvent(scanner);
    		}
    		else {
    			System.out.println("invalid input");
    		}
    		
    	}
    	scanner.close();
    }
    static //I NEED TO ADD A BUBBLE SORT TO MAKE THE EVENTS CHRONOLOGICAl
    void addEvent(Scanner scanner){
    	SchedulingConflictException exception = new SchedulingConflictException();
    	boolean dayFound = false;
    	boolean found = false;
    	int time = 0;
    	while (!found) {
			System.out.println("Which day  would you like to add the event?");
			String day = scanner.nextLine();
			for (int i = 0; i < days.length; i++) {
				if (days[i].name().equals(day)) {
					dayFound = true;
					System.out.println("So you want the event on " + day + "! What time do you want it to be? (format = 1400)");
					String temp = scanner.nextLine();
					time = Integer.parseInt(temp);
					System.out.println("What would you like the event name to be?");
					String name = scanner.nextLine();
					Event event = new Event(time, day, name);
					Node<Event> node = new Node<Event>(event);
				
					if (days[i].events.getHead() != null) {
						Node<Event> checker = days[i].events.getHead();
						while (checker != null)
							try {
								exception.checkDoubleBooking(checker, node);
							}
							catch (SchedulingConflictException e){
								System.out.println("You tried to do a double booking!");
								return;
							}
							checker = checker.getNext();
						}
						
						days[i].events.add(event);
						for (int j = 0; j < days[i].events.size(); j++) {	
							
						}
						found = true;
						System.out.println("added");
						return;
				}
					}
					
				}
			}
    	
    
    public static void removeEvent(Scanner scanner) {
    	boolean found = false;
    	int num = 0;
    	int time = 0;
    	while(!found) {
	    	System.out.println("What day do you want to remove the event?");
	    	String day = scanner.nextLine();
	    	for (int i = 0; i < days.length; i++) {
				if (days[i].name().equals(day)) {
					num = i;
					found = true;
				}
			}
	    	if (!found) {
	    		System.out.println("Invalid input");
	    	}
    	}
    	System.out.println("What is the time of the event?");
    	time = scanner.nextInt();
    	
    	
    	boolean foundNode = false;
    	while (!foundNode) {
    		Node<Event> node = days[num].events.getHead();
	    	while (node != null && !foundNode) {
	    		if (node.getValue().getTime() == time) {
	    			Node <Event> prev = node;
	    			Node<Event> next = node;
	    			if (node.getPrev() != null && node.getNext()!= null) {
	    				prev = node.getPrev();
	    				next = node.getNext();
	    				prev.setNext(next);
	    				next.setPrev(prev);
	    			}
	    			else if (node == days[num].events.getHead()) {
	    				days[num].events.setHead(null);
	    			}
	    			else {
	    				days[num].events.setTail(null);
	    			}
	    			
	    			foundNode = true;
	    			continue;
	    		}
	    		node = node.getNext();
	    	}
	    	if (!foundNode) {
	    		System.out.println("Invalid input");
	    	}
    	}
    	System.out.println("removed");
	    	
    }
    
}
    
    

