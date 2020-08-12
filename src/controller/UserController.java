package controller;

import java.util.ArrayList;

import io_Stream.IOHandler;
import io_Stream.IOUserData;
import model.DataBase;
import model.StrucnaSprema;
import model.User;
import model.UserType;

public class UserController {

	public User getUserByLBO(String lbo) {
		User user = DataBase.users.get(lbo);
		System.out.println(user.toString());
		return user;
	}
	
	public User createUser() {
		User u = new User();
		System.out.println("Molimo unesite ime pacijenta: ");
		u.setFirstName(IOHandler.stringInput());
		System.out.println("Molimo unesite prezime pacijenta: ");
		u.setLastName(IOHandler.stringInput());
		System.out.println("Molimo unesite email pacijenta: ");
		u.setEmail(IOHandler.stringInput());
		u.setPassword(u.getFirstName().toLowerCase());
		System.out.println("Unesite korisnikov LBO");
		u.setLBO(IOHandler.lboInput());
		System.out.println("Unesite pol korisnika: M/F ");
		String sex = IOHandler.stringInput();
		if(sex.toLowerCase().equals("m")) {
			u.setSex("m");
		}
		else if(sex.toLowerCase().equals("f")) {
			u.setSex("f");
		}
		System.out.println("Unesite datum rodjenja: ");
		u.setDateOfBirth(IOHandler.dateInput());
		System.out.println(("Unesite adresu: "));
		u.setAdress(IOHandler.stringInput());
		System.out.println("Unesite broj telefona: ");
		u.setPhoneNumber(IOHandler.stringInput());
		System.out.println("Tip korisnika:");
		System.out.println("1. Pacijent\n2. Laborant \n3. Medicinski tehnicar");
		
		int input = MenuController.chooseMenuOption(3, true);
		if(input == 1) {
			u.setUserType(UserType.PACIJENT);
		}
		else if(input == 2) {
			u.setUserType(UserType.LABORANT);
		}
		else if(input == 3) {
			u.setUserType(UserType.MEDICINSKI_TEHNICAR);
		}
		if(u.getUserType() != UserType.PACIJENT) {
			System.out.println("Unesite pocetak radnog odnosa: ");
			u.setPocetakRadnogOdnosa(IOHandler.dateInput());
			if(u.getUserType() == UserType.MEDICINSKI_TEHNICAR)
				u.setStrucnaSprema(StrucnaSprema.SSS_4);
			else if (u.getUserType() == UserType.LABORANT) {
				u.setStrucnaSprema(StrucnaSprema.SSS_6);
				System.out.println("Unesite specijalizacije Laboranta jednu za drugom odvojene zarezom: a,b,c");
				String s = IOHandler.stringInput();
				s.trim();
				String[] temp = s.split("\\,");
				ArrayList<String> spec = new ArrayList<>();
				for (int i = 0; i< temp.length; i++) {
					spec.add(temp[i]);
				}
				u.setSpecijalizacije(spec);		
			}
		}

		DataBase.users.put(u.getLBO(), u);
		IOUserData iouser = new IOUserData();
		iouser.updateUsers();
		
		return u;
	}
	
}
