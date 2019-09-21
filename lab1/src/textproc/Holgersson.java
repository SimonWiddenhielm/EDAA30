package textproc;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {
	/** Inför fortsättningen vill vi utöka programmet Holgersson så att det kan hantera flera
TextProcessor-implementationer på samma text.
Ändra programmet så att det har en lista av TextProcessor-objekt. Till att börja med
ska listan bara innehålla det enda objekt som finns sedan tidigare (och som räknar ”Nils”).
Varje gång ett ord lästs in ska alla TextProcessor-objekt i listan få sin process-metod
anropad. När all text har lästs in ska alla TextProcessor-objekt skriva ut sina respektive
resultat.
Lägg till en rad i ditt Holgersson-program, så att även antalet förekomster av ordet
”norge” räknas. Din lista ska alltså innehålla två TextProcessor-objekt, och du ska få
följande resultat: */

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland,norge" };

	public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();
		TextProcessor p = new SingleWordCounter("nils");
		ArrayList<TextProcessor>text = new ArrayList();
		TextProcessor l = new SingleWordCounter("norge");
		text.add(p);
		text.add(l);
		

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		TextProcessor count = new MultiWordCounter(REGIONS);
		

		TextProcessor gene = new GeneralWordCounter(genStopWords());
		
		

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for (TextProcessor pross : text) {
				pross.process(word);
				count.process(word);
				gene.process(word);
			}
		}

		s.close();

		/*for(TextProcessor proc : text) {
			proc.report();
		}
		count.report(); */
		Comparator comp = new WordCountComparator();
		gene.report();
		
	
	
	}
	public static Set<String> genStopWords() throws FileNotFoundException{
		Set<String>undan = new HashSet();
		File fajl = new File("undantagsord.txt");
		Scanner scan1 = new Scanner(fajl);
		scan1.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while( scan1.hasNext()) {
			undan.add(scan1.next().toLowerCase());
			
		}
		return undan;
		
		
	}
}