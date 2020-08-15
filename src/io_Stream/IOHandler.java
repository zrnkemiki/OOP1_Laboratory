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

	public static String newLboInput() {
		String unos;
		String lbo = "";
		boolean temp = true;
		while(temp)
		{
			unos = input.nextLine();
			try {
				if(unos.length()!= 6) {
					System.out.println("LBO mora da sadrzi 6 cifara. Pokusajte ponovo:");
					temp = true;
				}
				else if(DataBase.users.containsKey(unos)) {
					System.out.println("LBO ne postoji. Pokusajte ponovo:");
					temp = true;
				}
				else{
					lbo = unos;
					break;
				}
			} catch(Exception e) {
				System.out.println("Format nije validan!");
			}
		}
		return lbo;
	}
	
	public static String existingLboInput() {
		String unos;
		String lbo = "";
		boolean temp = true;
		while(temp)
		{
			unos = input.nextLine();
			try {
				if(unos.length()!= 6) {
					System.out.println("LBO mora da sadrzi 6 cifara. Pokusajte ponovo:");
					temp = true;
				}
				else if(!DataBase.users.containsKey(unos)) {
					System.out.println("LBO ne postoji. Pokusajte ponovo:");
					temp = true;
				}
				else{
					lbo = unos;
					break;
				}
			} catch(Exception e) {
				System.out.println("Format nije validan!");
			}
		}
		return lbo;
	}


}
