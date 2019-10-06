class Event{
	public double eventTime;
	public int eventType;
	public Event next;
	
	
	public String toString() {
		return Integer.toString(eventType);
	}
}


