package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String LBO;
	private String sex;
	private LocalDate dateOfBirth;
	private String adress;
	private String phoneNumber;
	private UserType userType;
	private List<Integer> analizeId;
	private StrucnaSprema strucnaSprema;
	private List<String> specijalizacije;
	private LocalDate pocetakRadnogOdnosa;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String email, String password, String lBO, String sex,
			LocalDate dateOfBirth, String adress, String phoneNumber, UserType userType, List<Integer> analizeId,
			StrucnaSprema strucnaSprema, List<String> specijalizacije, LocalDate pocetakRadnogOdnosa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.LBO = lBO;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
		this.analizeId = analizeId;
		this.strucnaSprema = strucnaSprema;
		this.specijalizacije = specijalizacije;
		this.pocetakRadnogOdnosa = pocetakRadnogOdnosa;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String lBO) {
		LBO = lBO;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Integer> getAnalizeId() {
		return analizeId;
	}

	public void setAnalizeId(List<Integer> analizeId) {
		this.analizeId = analizeId;
	}

	public StrucnaSprema getStrucnaSprema() {
		return strucnaSprema;
	}

	public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}

	public List<String> getSpecijalizacije() {
		return specijalizacije;
	}

	public void setSpecijalizacije(List<String> specijalizacije) {
		this.specijalizacije = specijalizacije;
	}

	public LocalDate getPocetakRadnogOdnosa() {
		return pocetakRadnogOdnosa;
	}

	public void setPocetakRadnogOdnosa(LocalDate pocetakRadnogOdnosa) {
		this.pocetakRadnogOdnosa = pocetakRadnogOdnosa;
	}

	@Override
	public String toString() {
		return firstName + "|" + lastName + "|" + email + "|" + password
				+ "|" + LBO + "|" + sex + "|" + dateOfBirth + "|" + adress
				+ "|" + phoneNumber + "|" + userType + "|" + analizeId
				+ "|" + strucnaSprema + "|" + specijalizacije + "|"
				+ pocetakRadnogOdnosa + "|";
	}

	

}
