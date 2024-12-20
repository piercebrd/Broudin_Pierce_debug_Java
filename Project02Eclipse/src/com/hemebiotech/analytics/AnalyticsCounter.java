package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	// getters and setters ? //

	public List<String> GetSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer> CountSymptoms(List<String> symptoms) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			result.put(symptom, result.getOrDefault(symptom, 0) + 1);
		}
		return result;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Use a TreeMap to automatically sort by keys
		return new TreeMap<>(symptoms);
	}

	public void WriteSymptoms(Map<String, Integer> symptoms) {
		writer.WriteSymptoms(symptoms);
	}

}


