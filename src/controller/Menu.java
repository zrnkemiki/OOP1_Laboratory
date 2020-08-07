package controller;

import java.util.Scanner;

import io_Stream.IOHandler;
import model.DataBase;
import model.User;
import model.UserType;

public class Menu {

	public void start() {
		User user = new User();
		user = login();
		while (true)
			userMenu(user);

	}

	public void userMenu(User user) {
		int input;
		if (user.getUserType() == UserType.ADMINISTRATOR) {
			System.out.println("-------------------------------------\n");
			System.out.println("1) Pregled korisnika.");
			System.out.println("2) Kreiranje menadzera");
			System.out.println("3) Izmena menadzera");
			System.out.println("4) Brisanje menadzera");
			System.out.println("0) Odjavljivanje.");
			input = chooseMenuOption(5, true);
			switch (input) {
			case 1:
				System.out.println("-------------------------------------\n");
				System.out.println("1) Menu 1");
				System.out.println("2) ");
				System.out.println("3) ");
				System.out.println("4) ");
				System.out.println("5) ");
				System.out.println("6) ");
				System.out.println("0) Izlazak iz programa");
				input = chooseMenuOption(7, true);
				
			case 0:
				System.out.println("Uspesno ste se izlogovali. \n");
				user = null;
				start();
				break;
			}

		}
	}
	
	public static int chooseMenuOption(int range, boolean saNulom) {
		int izbor = -1;
		int unetiBroj;
		while (izbor == -1) {
			System.out.print("Zelite opciju: ");
			unetiBroj = IOHandler.intInput();
			try {
				izbor = (unetiBroj);
			} catch (NumberFormatException e) {
				izbor = -1;
			}
			if (saNulom) {
				if (izbor < 0 || izbor >= range) {
					System.out.println("Opcija koju ste uneli ne postoji.\nPokusajte ponovo.");
					System.out.println("-------------------------------------");
					izbor = -1;
				}
			} else {
				if (izbor <= 0 || izbor > range) {
					System.out.println("Opcija koju ste uneli ne postoji.Pokusajte ponovo.");
					System.out.println("-------------------------------------");
					izbor = -1;
				}

			}
		}
		return izbor;
	}

	public User login() {

		User temp = new User();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String username;
		String password;
		boolean aktivan;

		while (true) {
			aktivan = true;
			System.out.println("\n**Welcome to OOP1 Laboratory**");
			System.out.println(" Please enter your username:");
			username = input.nextLine();
			if (username == "") {
				System.out.println("Username field cannot be empty.");
				continue;
			}
			System.out.println("Enter password:");
			password = input.nextLine();

			if (password == "") {
				System.out.println("Password field cannot be empty.");
				continue;
			}

			// ______________USERS LoGIN___________________
			for (String key : DataBase.users.keySet()) {
				if (DataBase.users.get(key).getEmail().equals(username)
						&& DataBase.users.get(key).getPassword().equals(password)) {

					System.out.println("Uspesno ste se logovali kao " + DataBase.users.get(key).getFirstName() + " "
							+ DataBase.users.get(key).getLastName() + " sa ulogom "
							+ DataBase.users.get(key).getUserType() + "-a.");
					temp = DataBase.users.get(key);

					aktivan = false;

					return temp;
				}
			}

			if (aktivan) {
				System.out.println("Korisnicko ime/Lozinka nisu dobri.");
			} else
				continue;
		}
	}
}
