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



	/* private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	} */
}
