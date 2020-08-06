package io_Stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Analiza;
import model.StrucnaSprema;
import model.User;
import model.UserType;

public class LoadData {
	private List<User> users;
	
	
public LoadData() {
		super();
		this.users = new ArrayList<User>();
		// TODO Auto-generated constructor stub
	}

	
	
	public List<User> loadUsers() throws ParseException, NumberFormatException, IOException
	{
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/Data/users.txt"), "utf-8"));
			String s;
			while((s = in.readLine()) != null) {
				s = s.trim();
				String[] tokens = s.split("\\|");
				System.out.println("Token 0: " + tokens[0]);
					if(tokens[9].equals("PACIJENT")) {
						User u = new User();
						u.setFirstName(tokens[0]);
						u.setLastName(tokens[1]);
						u.setEmail(tokens[2]);
						u.setPassword(tokens[3]);
						u.setLBO(tokens[4]);
						u.setSex(tokens[5]);
						u.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[6])); 
						u.setAdress(tokens[7]);
						u.setPhoneNumber(tokens[8]);
						u.setUserType(UserType.valueOf(tokens[9]));
						String[] analize = tokens[10].split("\\;");
						ArrayList<Integer> analizeID = new ArrayList<>();
						for(int i= 0; i<analize.length; i++) {
							analizeID.add(Integer.parseInt(analize[i]));
						}
						u.setAnalizeId(analizeID);
						users.add(u);
					}
					else if(tokens[9].equals("LABORANT")) {
						User u = new User();
						u.setFirstName(tokens[0]);
						u.setLastName(tokens[1]);
						u.setEmail(tokens[2]);
						u.setPassword(tokens[3]);
						u.setLBO(tokens[4]);
						u.setSex(tokens[5]);
						u.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[6])); 
						u.setAdress(tokens[7]);
						u.setPhoneNumber(tokens[8]);
						u.setUserType(UserType.valueOf(tokens[9]));
						try {
							String[] analize = tokens[10].split("\\;");
							ArrayList<Integer> analizeID = new ArrayList<>();
							for(int i= 0; i<analize.length; i++) {
								analizeID.add(Integer.parseInt(analize[i]));
							}
							u.setAnalizeId(analizeID);
						} catch (Exception e) {
							System.out.println("Korisnik nema analiza");						}
						
						
						u.setStrucnaSprema(StrucnaSprema.valueOf(tokens[11]));
						String[] specTokens = tokens[12].split("\\?");
						ArrayList<String> specijalizacije = new ArrayList<>();
						for(int i= 0; i<specTokens.length; i++) {
							specijalizacije.add(specTokens[i]);
						}
						u.setSpecijalizacije(specijalizacije);
						u.setPocetakRadnogOdnosa(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[13]));
						//To-Do Specijalizacije
						//u.setSpecijalizacije(specijalizacije);
						users.add(u);
						}
					else if(tokens[9].equals("ADMINISTRATOR")) {
						User u = new User();
						u.setFirstName(tokens[0]);
						u.setLastName(tokens[1]);
						u.setEmail(tokens[2]);
						u.setPassword(tokens[3]);
						u.setLBO(tokens[4]);
						u.setSex(tokens[5]);
						u.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[6])); 
						u.setAdress(tokens[7]);
						u.setPhoneNumber(tokens[8]);
						u.setUserType(UserType.valueOf(tokens[9]));
						try {
							String[] analize = tokens[10].split("\\;");
							ArrayList<Integer> analizeID = new ArrayList<>();
							for(int i= 0; i<analize.length; i++) {
								analizeID.add(Integer.parseInt(analize[i]));
							}
							u.setAnalizeId(analizeID);
						} catch (Exception e) {
							System.out.println("Korisnik nema analiza");						}
						
						
						u.setStrucnaSprema(StrucnaSprema.valueOf(tokens[11]));
						
						u.setPocetakRadnogOdnosa(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[12]));
						//To-Do Specijalizacije
						//u.setSpecijalizacije(specijalizacije);
						users.add(u);
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
}


	
