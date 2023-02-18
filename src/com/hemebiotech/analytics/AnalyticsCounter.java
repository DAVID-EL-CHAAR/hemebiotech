package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> countMap = new HashMap<>();

		for (String element : symptoms) {

			if (countMap.containsKey(element)) {
				countMap.put(element, countMap.get(element) + 1);
			}

			else {
				countMap.put(element, 1);
			}
		}

		return countMap;
	}

	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<String, Integer>(symptoms);
		
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

}
