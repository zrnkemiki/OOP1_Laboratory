package io_Stream;

import java.time.LocalDate;
import java.util.Scanner;

import model.DataBase;

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
	
	public static LocalDate dateInput() {
		String unos;
		LocalDate date;
		while(true)
		{
			unos = input.nextLine();
			try {
				date = LocalDate.parse(unos);
				break;
			} catch(Exception e) {
				System.out.println("Date format not valid!");
			}
		}
		return date;
	}

	public static String stringInput() {
		String unos;
		String output;
		while(true)
		{
			unos = input.nextLine();
			try {
				output = unos;
				break;
			} catch(Exception e) {
				System.out.println("Format not valid!");
			}
		}
		return output;
	}

	public static String lboInput() {
		String unos;
		String lbo = "";
		boolean temp = true;
		while(temp)
		{
			unos = input.nextLine();
			try {
				if(unos.length()!= 6) {
					System.out.println("LBO must contain 6 characters. Try other one:");
					temp = true;
				}
				else if(DataBase.users.containsKey(unos)) {
					System.out.println("LBO already exists. Try other one:");
					temp = true;
				}
				else{
					lbo = unos;
					break;
				}
			} catch(Exception e) {
				System.out.println("Format not valid!");
			}
		}
		return lbo;
	}


}
