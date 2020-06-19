package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> fib = new ArrayList<Integer>();
		int num = 1;

		fib.add(0);
		fib.add(1);

		while (num < 350) {
			num = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
			fib.add(num);
		}

		return fib;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}