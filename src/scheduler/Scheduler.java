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
    	while (forever) {
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("What would you like to do?");
    		String input = scanner.nextLine();
    		if(input.equals("add")) {
    			//ADD BUBBLE SORT TO ADD EVENT METHOD
    			addEvent(scanner);
    		}
    		else if(input.equals("view") ) {
    			
    		}
    		else if(input.equals("remove")) {
    			
    		}
    		else {
    			scanner.close();
    			continue;
    		}
    	
    		scanner.close();
    	}
    }
    static //I NEED TO ADD A BUBBLE SORT TO MAKE THE EVENTS CHRONOLOGICAl
    void addEvent(Scanner scanner){
    	SchedulingConflictException exception = new SchedulingConflictException();
    	boolean found = false;
    	int time = 0;
    	while (!found) {
			System.out.println("Which day  would you like to add the event?");
			String day = scanner.nextLine();
			for (int i = 0; i < days.length; i++) {
				if (days[i].name().equals(day)) {
					System.out.println("So you want the event on " + day + "! What time do you want it to be? (format = 1400)");
					time = scanner.nextInt();
					Event event = new Event(time, day);
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
						Node<Event> list = days[i].events.getTail();
						Node<Event> prev = days[i].events.getTail();
						prev = prev.getPrev();
						days[i].events.setTail(node);
						prev.setNext(list);
						list.setNext(node);
						for (int o = 0; o < days.length; o++) {	
							for (int j = 0; j < days.length; j++) {
								//THIS SHOULD BE THE BUBBLE SORT	
							}
						}
					}
					else {
						Event event = new Event(time, day);
						Node<Event> node = new Node<Event>(event);
						
						days[i].events.setHead(node);
					}
					found = true;
					return;
				}
			}
    	}
    
    }
    
    

