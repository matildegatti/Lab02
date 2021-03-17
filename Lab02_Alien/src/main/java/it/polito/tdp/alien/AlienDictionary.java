package it.polito.tdp.alien;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

	List<Word> dictionary;
	Map<String,Word> mapdictionary;
	
	public AlienDictionary(){
		dictionary=new LinkedList<Word>();
		mapdictionary=new HashMap<String,Word>();
	}
	
	public void addWord(String alienword, String translation) {
		if(mapdictionary.containsKey(alienword)) {
			mapdictionary.get(alienword).setTranslation(translation);
		}
		else {
			Word parola=new Word(alienword,translation);
			mapdictionary.put(alienword, parola);
			dictionary.add(parola);
		}
	}
	
	public String translateWord(String alienword) {
		return mapdictionary.get(alienword).getTranslation();
	}
}
