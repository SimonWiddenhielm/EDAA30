package textproc;
import java.util.*;
import java.util.Map.Entry;
public class WordCountComparator implements Comparator<Map.Entry<String,Integer>> {
	public static void main(String[]args) {
		
	
	
	}

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if (o2.getValue() == o1.getValue()) {
			return o2.getKey().hashCode() - o1.getKey().hashCode();
		}
		return o2.getValue() - o1.getValue();
	}
	

}
