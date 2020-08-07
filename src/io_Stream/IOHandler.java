package io_Stream;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static Date dateInput() {
		String unos;
		Date date;
		while(true)
		{
			unos = input.nextLine();
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(unos);
				break;
			} catch(Exception e) {
				System.out.println("Date format not valid!");
			}
		}
		return date;
	}

}
