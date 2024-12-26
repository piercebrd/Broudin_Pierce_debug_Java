package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class that retrieves, counts, sorts and prints the symptoms and occurrences
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor to instantiate a symptom reader and writer, so the methods from ReadData and WriteData can be called
	 * @param reader instance of the ISymptomReader interface
	 * @param writer instance of the ISymptomWriter interface
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	// getters and setters ? //

	/**
	 * Transform the input file into an exploitable java object
	 * @return A java List with all the symptoms, unsorted, and not counted
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Turns the list created by GetSymptoms into an unsorted Map of symptoms and their occurrences
	 * @param symptoms A Java List of symptoms
	 * @return A Java Map whose key is the symptom and value is the amount of times it occurs
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			result.put(symptom, result.getOrDefault(symptom, 0) + 1);
		}
		return result;
	}

	/**
	 * Sorts the Map
	 * @param symptoms A Java Map whose key is the symptom and value is the amount of times it occurs
	 * @return A sorted Java map, with the symptoms and their counts
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Use a TreeMap to automatically sort by keys
		return new TreeMap<>(symptoms);
	}

	/**
	 * Method that prints the sorted Java Map to a specified file
	 * @param symptoms A sorted Java map, with the symptoms and their counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}


