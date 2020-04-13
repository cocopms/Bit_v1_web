package com.jse.phone;

public interface PhoneService {
	public CellPhone[] getCellphone();
	public void setPhone(Phone[] phones);
	public Phone[] getPhone();
	public void setcount(int count);
	public GalaxyNote[] getGalaxynotes();
	public void setGalaxynotes(GalaxyNote[] galaxynotes);
	public int getcount();
	public void add(Phone phone);
	public void add(CellPhone cellphone);
	public void add(Iphone iphone);
	public void add(GalaxyNote galaxynote);
	public String printphone();
	public String printcell();
	public String printiphone();
	public String printgalaxy();
}
