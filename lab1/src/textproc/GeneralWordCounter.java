package textproc;
import java.util.*;
public class GeneralWordCounter implements TextProcessor {
	
	
	private Map<String,Integer> gCount;
	private Set<String>stopwords;
	public GeneralWordCounter(Set<String> stopwords) {
		gCount = new HashMap();
		this.stopwords=stopwords;
	}
	
	
	/** Metoden process räknar alla ord, såvida de inte finns i mängden av undantagsord.
	 *  Första gången ett nytt ord upptäcks läggs det till med antalet 1, och påföljande
		gånger samma ord upptäcks ökas dess antal med ett. */
	@Override
	public void process(String w) {
		if (stopwords.contains(w)) {
			return;
		}
		if (!gCount.containsKey(w)) {
			gCount.put(w,1);
			return;
		}
		int n = gCount.get(w);
		n++;
		gCount.put(w,n);

		
	}
	
	/**Metoden report ska skriva ut alla ord som förekommer 200 gånger eller fler */
	@Override
	public void report() {
		/*for(String s: gCount.keySet()) {
			if(gCount.get(s)>=200) {
				System.out.println(s + ": " + gCount.get(s));
			}
			
		}*/
		Set<Map.Entry<String, Integer>> wordSet = gCount.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		Comparator comp = new WordCountComparator();
		wordList.sort(comp);
		for (int i = 0; i<5;i++) {
			System.out.println(wordList.get(i));
			
		}
		
	}
	

}
