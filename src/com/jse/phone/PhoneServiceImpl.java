package com.jse.phone;

public class PhoneServiceImpl implements PhoneService {
	private Phone[] phones;
	private CellPhone[] cellphones;
	private Iphone[] iphones;
	private GalaxyNote[] galaxynotes;
	private int count;
	String result;

	public PhoneServiceImpl() {
		phones = new Phone[3];
		cellphones = new CellPhone[3];
		iphones = new Iphone[3];
		galaxynotes = new GalaxyNote[3];
		this.count = 0;
		this.result = "";
	}
	
	public CellPhone[] getCellphones() {
		return cellphones;
	}

	public void setIphones(Iphone[] iphones) {
		this.iphones = iphones;
	}

	public Iphone[] getIphones() {
		return iphones;
	}

	public void setCellphones(CellPhone[] cellphones) {
		this.cellphones = cellphones;
	}

	public CellPhone[] getCellphone() {
		return cellphones;
	}

	public void setPhone(Phone[] phones) {
		this.phones = phones;
	}

	public Phone[] getPhone() {
		return phones;
	}

	public void setcount(int count) {
		this.count = count;
	}

	public GalaxyNote[] getGalaxynotes() {
		return galaxynotes;
	}

	public void setGalaxynotes(GalaxyNote[] galaxynotes) {
		this.galaxynotes = galaxynotes;
	}

	public int getcount() {
		return count;
	}

	public void add(Phone phone) { // 하나씩 받는 것을 추가함 set의 역할을 하지만 set을 붙이면 헷갈려!
		phones[count] = phone; // 오버로딩 : 이름은 같아도 상관 없다. 파라미터 "타입"만 맞춰주면 된다. 기준은 타입이다
		count++;
	}

	public void add(CellPhone cellphone) { // 왜 phone을 중첩해도 괜찮은가?
		cellphones[count] = cellphone;
		count++;
	}

	public void add(Iphone iphone) {
		iphones[count] = iphone;
		count++;
	}

	public void add(GalaxyNote galaxynote) {
		galaxynotes[count] = galaxynote;
		count++;
	}

	public String printphone() {
		for (int i = 0; i < 3; ++i) {
			result += String.format("번호 : %s, 이름 : %s, 회사 : %s \n", phones[i].getPhonenumber(), phones[i].getName(), phones[i].getCompany());
		}
		return result;

	}
	
	public String printcell() {
		for (int i = 0; i < 3; ++i) {
			result += String.format("번호 : %s, 이름 : %s, 회사 : %s \n", phones[i].getPhonenumber(), phones[i].getName(), phones[i].getCompany());
		}
		return result;
	}

	public String printiphone() {
		for (int i = 0; i < 3; ++i) {
			result += String.format("번호 : %s, 이름 : %s, 회사 : %s, 검색어 \n", phones[i].getPhonenumber(), phones[i].getName(), phones[i].getCompany(), phones.getSearch);
		}
		return result;
	}
	
	public String printgalaxy() {
		for (int i = 0; i < 3; ++i) {
			result += galaxy[i].toString()+"\n";
		}
		return result;
	}
}