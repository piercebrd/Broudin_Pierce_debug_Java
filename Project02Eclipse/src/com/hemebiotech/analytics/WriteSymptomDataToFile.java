package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    /**
     * Constructor that allows the user to specify where the symptoms and their occurrences will be printed
     * @param filepath The path where the text will be written
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Method that writes symptoms and occurrences in a specified file, with one symptom and its corresponding
     * occurrence per line.
     *
     * @param symptoms A Map whose key is the symptom and value is the amount of time it occurs
     */

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null && symptoms != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}