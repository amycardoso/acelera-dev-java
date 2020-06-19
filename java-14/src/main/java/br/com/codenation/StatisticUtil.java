package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		Double average = Arrays.stream(elements).average().getAsDouble();
		return average.intValue();
	}

	public static int mode(int[] elements) {
		int mode = 0, maxFreq = 0;

		for (int i = 0; i < elements.length; ++i) {
			int count = 0;
			for (int j = 0; j < elements.length; ++j) {
				if (elements[j] == elements[i])
					++count;
			}
			if (count > maxFreq) {
				maxFreq = count;
				mode = elements[i];
			}
		}

		return mode;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		return (elements[elements.length / 2] + elements[(elements.length - 1) / 2]) / 2;
	}
}