package io_Stream;

import java.util.Scanner;

public class IOHandler {
	

	static Scanner input = new Scanner(System.in);
	
	public static int intInput() {
		String unos;
		int broj;
		while (true)
		{
			unos = input.nextLine();
			try {
				broj = Integer.parseInt(unos);
				break;
			} catch (Exception e) {
				System.out.println("Only number input is accepted.");
			}
			
		}
		return broj;
	}

}
