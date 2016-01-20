package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagram {
	//this map will contain each words's anagram
	final static Map<String, List<String>> lookup = new HashMap<String, List<String>>();

	public static void main(String[] args) {
		List<String> wordList = new ArrayList();
		wordList.add("12345");
		wordList.add("54321");
		wordList.add("789");
		
		Anagram(wordList);
		
		for(String s : getAnagrams("12345"))
			System.out.println(s);

	}
	
	public static void Anagram(final List<String> words){
		for (final String word: words){
			final String signature = alphabetize(word);
			
			if(lookup.containsKey(signature)){
				lookup.get(signature).add(word);
			}
			else{
				final List<String> anagramList = new ArrayList<String>();
				anagramList.add(word);
				lookup.put(signature, anagramList);
			}
		}
	}
	
	//get the word byte array and sort it, it will make signature of this word
	private static String alphabetize(final String word){
		final byte[] bytes = word.getBytes();
		Arrays.sort(bytes);
		
		return new String(bytes);
	}
	
	public static List<String> getAnagrams(final String word){
		final String signature = alphabetize(word);
		
		final List<String> anagrams = lookup.get(signature);
		
		return anagrams == null ? new ArrayList<String>() : anagrams;
	}

}
