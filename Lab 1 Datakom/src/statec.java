
public class statec {
	//jobbA arrival
		private void typeA(){
			
			//om A s queue nummer är 0, betyder A är framme på betjäningen, och om det finns INTE B, kan betjäna A
			if(numberInQueueA==0 && numberInQueueB==0)
				InsertEvent(READYA, time + 0.002);
			
			//jobb A arrival varje 1.0/150 sekund, så insert A i queue, och queue nummer ökar
			numberInQueueA++;
			InsertEvent(TYPEA, time + generateMean(1.0/150));
		}
		
		//samma som typeA,men inte insertEvent typeB här, eftersom typeB kommer bara ifrån BETJNING av jobb A, alltså readyA metode
		private void ArrivalB(){
			
			if(numberInQueueB==0 ) { 
				InsertEvent(READYB, time + 0.004);
			}
			numberInQueueB++;
		}
		// betjäna A
		private void readyA(){
			numberInQueueA--;	
			//efter vi betjännar ett jobb, behöver lägga ett jobb i betjäningen.
			//om det finns inte B i queue, och finns A stå i kö, lägg a till betjänningen.
			if (numberInQueueA > 0 && numberInQueueB==0)
				InsertEvent(READYA, time + 0.002);
			//om det finns B i kö, måste lägga B i betjäning, för att B är prio än A
			if(numberInQueueB > 0)
				InsertEvent(READYB, time + 0.004);
			//efter betjäna A, komma ut en B efter 1 sekund
			InsertEvent(TYPEB, time+1);
			
		}
		
		//samma som readyA
		private void readyB(){ // ifall B-kön inte är tom så lägger vi in ett event ReadyB Ifall A K*/
			numberInQueueB--;
			if (numberInQueueB > 0) {
				InsertEvent(READYB, time + 0.004); 
			}
			
			else if(numberInQueueA > 0) {
				InsertEvent(READYA, time + 0.002);
			}
			
		}
		private void measure(){
			accumulated = accumulated + numberInQueueA+numberInQueueB;
			noMeasurements++;
			//measure varje 0.1 sekund
			InsertEvent(MEASURE, time + 0.1);
			
		}
}

}
