package edu.gatech.cs1331.wc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Comparator;

//avoid name collision
//mx-sort lines

public class WordCounter {

	private Map<String, Integer> counts;

	// private class RankComparator implements Comparator<String> {
	// //always give a minimum scope!
	// 	public int compare(String w1, String w2) {
	// 		int diff = counts.get(w1) - counts.get(w2);
	// 		return diff == 0 ? w1.compareTo(w2) : diff;
	// 	}
	// }

	private String normalize(String word) {
		return word;
	}

	public WordCounter(String name) throws FileNotFoundException {
		File file = new File(name);
		Scanner fs = new Scanner(file);

		//Map<String, Integer> counts = new HashMap<>();
		//counts should not be local variable

		counts = new HashMap<>();

		//Map<String, Integer> counts = new HashMap<>();
		//Type arguments has to be class or interface
		//auto boxing? auto unboxing?

		//Unreported exception:
		while(fs.hasNext()) {
			String word = fs.next();
			//next() returns string

			if(counts.containsKey(word)) {
				int currentCount = counts.get(word);
				counts.put(word, currentCount + 1);
			} else{
				counts.put(word, 1);
			}
			
		}

	}

	// public Collection<String> words() {
	// 	//String type, object default
	// 	return counts.keySet();
	// }


	public Collection<String> words() {
		//String type, object default
		
		//TreeSet constructor takes a comparator type
		TreeSet<String> sortedWords = new TreeSet<>((String w1, String w2) -> {
				int diff = counts.get(w1) - counts.get(w2);
				return diff == 0 ? w1.compareTo(w2) : diff;
			}
		);

		sortedWords.addAll(counts.keySet());
		return sortedWords;
	}

	public int count(String word) {
		return counts.get(word);
	}
}