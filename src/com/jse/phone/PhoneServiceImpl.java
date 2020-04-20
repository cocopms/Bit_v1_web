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
	
	@Override
	public Phone[] list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone detail() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int count() {
		return count;
	}
	
	@Override
	public CellPhone[] list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CellPhone detail() {
		return null;
	}
	
	@Override
	public Iphone[] list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iphone detail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public GalaxyNote[] list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GalaxyNote detail() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void update(Phone phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(cellPhone cellphone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Iphone iphone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GalaxyNote galaxynote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Phone phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(cellPhone cellphone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iphone iphone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GalaxyNote galaxynote) {
		// TODO Auto-generated method stub
		
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
			result += String.format("번호 : %s, 이름 : %s, 회사 : %s, 검색어 \n", phones[i].getPhonenumber(), phones[i].getName(), phones[i].getCompany(), phones.getSearch());
		}
		return result;
	}
	
	public String printgalaxy() {
		for (int i = 0; i < 3; ++i) {
			result += galaxynotes[i].toString()+"\n";
		}
		return result;
	}

}