import java.util.*;

class State extends GlobalSimulation{
	
	public int numberInQueA = 0,numberInQueB = 0, accumulated = 0, noMeasurements = 0;
	
	private EventList myEventList;

	Random slump = new Random();
	
	State(EventList x){
		myEventList = x;
	}
	
	private void InsertEvent(int event, double timeOfEvent){
		myEventList.InsertEvent(event, timeOfEvent);
		
		
	}
	
	
	public void TreatEvent(Event x){
		switch (x.eventType){
		
		
			
			case A:
				arrivalA();
				break;
			case B:
				arrivalB();
				break;
			case aREADY:
				readyA();
				break;
			case bREADY:
				readyB();
				break;
			case MEASURE:
				measure();
				break;
		}
	}
	/** */
	

	
	private double generateMean(){
		return 2*1.0/150*slump.nextDouble();
	}
	/** 1: Ifall kön är helt tom så går A direkt till ready & ett event av typen B sätts in
	 * 2: Ett event av typen A sätts in med frekvensen 150^-1 
	 * */
	private void arrivalA(){
		if(numberInQueA==0 && numberInQueB==0)
			InsertEvent(aREADY, time + 0.002);
		
		//jobb A arrival varje 1.0/150 sekund, så insert A i queue, och queue nummer ökar
		numberInQueA++;
		InsertEvent(A, time + generateMean());
	}
	private void arrivalB(){
		
		if(numberInQueB==0 ) { 
			InsertEvent(aREADY, time + 0.004);
		}
		numberInQueB++;
	}
	private void readyB() {
		numberInQueB--;
		if( numberInQueB >0)  {
		InsertEvent(bREADY, time + 0.004);
		
		}
		else if (numberInQueA > 0) {
			InsertEvent(aREADY, time + 0.002);
			
		}

		
	}
	
		
	
	/** ifall kön är tom*/
	private void readyA(){	
		numberInQueA--;	

		if (numberInQueA > 0 && numberInQueB==0)
			InsertEvent(aREADY, time + 0.002);
	
		if(numberInQueB > 0)
			InsertEvent(bREADY, time + 0.004);
		
		InsertEvent(B, time+1);
		
		
	}
	

	private void measure(){
			accumulated = accumulated + numberInQueA+numberInQueB;
			noMeasurements++;
	
			InsertEvent(MEASURE, time + 0.1); // Vänta 0.1 sekunder mellan varje mätning
			
	}
}