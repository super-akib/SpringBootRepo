package sbean;

import org.springframework.beans.factory.annotation.Autowired;


public class Event {
 
	private String  date ;
	private String  time;
	private String location;
	private String description;
	
	@Autowired
	public Event(String date, String time, String location, String description)
	{
		super();
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [date=" + date + ", time=" + time + ", location=" + location + ", description=" + description
				+ "]";
	}
	
	
	
	
	
}
