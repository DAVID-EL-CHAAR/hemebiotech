package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String args[]) throws Exception {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter ac = new AnalyticsCounter(reader, writer);
		List<String> liste = ac.getSymptoms();
		Map<String, Integer> map = ac.countSymptoms(liste);
		Map<String, Integer> mapSorted = ac.sortSymptoms(map);
		ac.writeSymptoms(mapSorted);
	}

}
