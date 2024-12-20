package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class, where the program will be executed.
 */
public class Main {
    /**
     * Main method, runs the project.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String args[]) {
        // Creates instances of the ISymptomReader and ISymptomWriter interfaces thanks to their constructors.

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Creates an instance of the AnalyticsCounter class

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.GetSymptoms();

        Map<String, Integer> symptomCount = analyticsCounter.CountSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCount);

        analyticsCounter.WriteSymptoms(sortedSymptoms);
    }
}
