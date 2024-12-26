package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writes symptoms and their occurrences from an input Map to a specified output file.
 */
public interface ISymptomWriter {
    /**
     * Writes symptoms and their occurrences from an input Map to a specified output file.
     *
     * @param symptoms A Map whose key is the symptom and value is the amount of time it occurs
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
