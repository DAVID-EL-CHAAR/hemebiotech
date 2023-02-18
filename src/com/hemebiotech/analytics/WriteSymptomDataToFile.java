package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	public WriteSymptomDataToFile() {
	};

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		File file = new File("result.out");

		BufferedWriter bf = null;

		try {

			bf = new BufferedWriter(new FileWriter(file));

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

				bf.write(entry.getKey() + "=" + entry.getValue() + "");

				bf.newLine();
			}

			bf.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {

				bf.close();
			} catch (Exception e) {
			}
		}

	}

}
