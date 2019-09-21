package textproc;
import java.util.*;
public class MultiWordCounter implements TextProcessor {
	/**D5. Hittills har vi behövt skapa ett nytt objekt för varje ord vi räknar. Nu vill vi införa en ny
typ av textanalys, där inte bara ett enda ord räknas, utan flera. Vi ska räkna hur många
gånger de olika svenska landskapen nämns i boken.
Skapa en ny klass MultiWordCounter, som implementerar interfacet TextProcessor
och fungerar enligt följande:
• Konstruktorn ska ta en vektor av strängar som parameter. Vektorn innehåller de ord
vi vill räkna. Följande exempel visar hur en sådan konstruktor ska fungera:
String[] landskap = { "blekinge", "bohuslän" /* , ... */ 
/**TextProcessor r = new MultiWordCounter(landskap);
• Din klass MultiWordCounter ska ha exakt ett attribut, och det attributet ska vara av
typen Map (med lämpliga typargument – jämför med förberedelseuppgifterna).
Detta Map-attribut används för att hålla reda på hur många gånger de sökta orden
(landskapsnamn i exemplet ovan) förekommer. Inledningsvis innehåller denna Map
värdet 0 (noll) för varje sökt ord (landskapsnamn). Metoden process ökar antalet om
ett givet ord är ett av de sökta orden.
• Även om attributet har typen Map, så ska det objekt som skapas för det vara av
den konkreta klassen HashMap. På så vis blir ditt program, så långt som möjligt,
oberoende av vilken implementation av Map-interfacet som faktiskt används.
Namnet HashMap ska alltså bara förekomma på ett ställe i klassen (förutom ev.
import-satser).
• Metoden report ska skriva ut alla nycklar och respektive värden i din Map.*/
				
	Map<String,Integer>wordC;
	public MultiWordCounter(String[]landskap) {
		wordC = new HashMap<String, Integer>();
		for(int i = 0;i<landskap.length;i++) {
			wordC.put(landskap[i], 0);
		}
		
	}
	@Override
	public void process(String w) {
		for (String s : wordC.keySet()) {
			if (s.equals(w)) {
				int n = wordC.get(s);
				n++;
				wordC.put(s,n);
				
			}
			
	}
		

	
	
}
	@Override
	public void report() {
		// TODO Auto-generated method stub
		for (String s : wordC.keySet()) {
			System.out.println(s + ": " + wordC.get(s));
		}
		
	}




}
