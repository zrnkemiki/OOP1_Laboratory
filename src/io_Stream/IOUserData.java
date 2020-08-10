package io_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.DataBase;
import model.StrucnaSprema;
import model.User;
import model.UserType;

public class IOUserData {
	
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;
	
	private List<User> users;

	public IOUserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<User> loadUsers() throws ParseException, NumberFormatException, IOException {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/Data/users.txt"), "utf-8"));
			String s;
			while ((s = in.readLine()) != null) {
				s = s.trim();
				String[] tokens = s.split("\\|");
				if (tokens[9].equals("PACIJENT")) {
					User u = new User();
					u.setFirstName(tokens[0]);
					u.setLastName(tokens[1]);
					u.setEmail(tokens[2]);
					u.setPassword(tokens[3]);
					u.setLBO(tokens[4]);
					u.setSex(tokens[5]);
					u.setDateOfBirth(LocalDate.parse(tokens[6]));
					u.setAdress(tokens[7]);
					u.setPhoneNumber(tokens[8]);
					u.setUserType(UserType.valueOf(tokens[9]));
					String[] analize = tokens[10].split("\\,");
					ArrayList<Integer> analizeID = new ArrayList<>();
					for (int i = 0; i < analize.length; i++) {
						analizeID.add(Integer.parseInt(analize[i].trim()));
					}
					u.setAnalizeId(analizeID);
					DataBase.users.put(u.getLBO(), u);
				} else if (tokens[9].equals("LABORANT")) {
					User u = new User();
					u.setFirstName(tokens[0]);
					u.setLastName(tokens[1]);
					u.setEmail(tokens[2]);
					u.setPassword(tokens[3]);
					u.setLBO(tokens[4]);
					u.setSex(tokens[5]);
					u.setDateOfBirth(LocalDate.parse(tokens[6]));
					u.setAdress(tokens[7]);
					u.setPhoneNumber(tokens[8]);
					u.setUserType(UserType.valueOf(tokens[9]));
					try {
						String[] analize = tokens[10].split("\\,");
						ArrayList<Integer> analizeID = new ArrayList<>();
						for (int i = 0; i < analize.length; i++) {
							analizeID.add(Integer.parseInt(analize[i].trim()));
						}
						u.setAnalizeId(analizeID);
					} catch (Exception e) {
					}

					u.setStrucnaSprema(StrucnaSprema.valueOf(tokens[11]));
					String[] specTokens = tokens[12].split("\\?");
					ArrayList<String> specijalizacije = new ArrayList<>();
					for (int i = 0; i < specTokens.length; i++) {
						specijalizacije.add(specTokens[i]);
					}
					u.setSpecijalizacije(specijalizacije);
					u.setPocetakRadnogOdnosa(LocalDate.parse(tokens[13]));
					// To-Do Specijalizacije
					// u.setSpecijalizacije(specijalizacije);
					DataBase.users.put(u.getLBO(), u);
				} else if (tokens[9].equals("ADMINISTRATOR")) {
					User u = new User();
					u.setFirstName(tokens[0]);
					u.setLastName(tokens[1]);
					u.setEmail(tokens[2]);
					u.setPassword(tokens[3]);
					u.setLBO(tokens[4]);
					u.setSex(tokens[5]);
					u.setDateOfBirth(LocalDate.parse(tokens[6]));
					u.setAdress(tokens[7]);
					u.setPhoneNumber(tokens[8]);
					u.setUserType(UserType.valueOf(tokens[9]));
					try {
						tokens[9].trim();
						String[] analize = tokens[10].split("\\,");
						ArrayList<Integer> analizeID = new ArrayList<>();
						for (int i = 0; i < analize.length; i++) {
							analizeID.add(Integer.parseInt(analize[i].trim()));
						}
						u.setAnalizeId(analizeID);
					} catch (Exception e) {
					}

					u.setStrucnaSprema(StrucnaSprema.valueOf(tokens[11]));

					u.setPocetakRadnogOdnosa(LocalDate.parse(tokens[12]));
					// To-Do Specijalizacije
					// u.setSpecijalizacije(specijalizacije);
					DataBase.users.put(u.getLBO(), u);

				}
				else if (tokens[9].equals("MEDICINSKI_TEHNICAR")) {
					User u = new User();
					u.setFirstName(tokens[0]);
					u.setLastName(tokens[1]);
					u.setEmail(tokens[2]);
					u.setPassword(tokens[3]);
					u.setLBO(tokens[4]);
					u.setSex(tokens[5]);
					u.setDateOfBirth(LocalDate.parse(tokens[6]));
					u.setAdress(tokens[7]);
					u.setPhoneNumber(tokens[8]);
					u.setUserType(UserType.valueOf(tokens[9]));
					try {
						String[] analize = tokens[10].split("\\,");
						ArrayList<Integer> analizeID = new ArrayList<>();
						for (int i = 0; i < analize.length; i++) {
							analizeID.add(Integer.parseInt(analize[i].trim()));
						}
						u.setAnalizeId(analizeID);
					} catch (Exception e) {
					}

					u.setStrucnaSprema(StrucnaSprema.valueOf(tokens[11]));

					u.setPocetakRadnogOdnosa(LocalDate.parse(tokens[12]));
					// To-Do Specijalizacije
					// u.setSpecijalizacije(specijalizacije);
					DataBase.users.put(u.getLBO(), u);

				}

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUsers() {
		String sadrzaj = "";
		for (User u : DataBase.users.values()) {
			System.out.println(u);
			if(u.getAnalizeId() == null) {
				u.setAnalizeId(new ArrayList<Integer>());
			}
			System.out.println(u);
			sadrzaj += u.toString().replace("|null|", "|").replace("[", "").replace("]", "").replace("|null", "") + "\n";

		}
		try {
			fw = new FileWriter("src/Data/users.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
