package com.jse.phone;

public interface PhoneService {
	
	public void add(Phone phone);
	public void add(CellPhone phone);
	public void add(Iphone phone);
	public void add(GalaxyNote phone);

	public Phone[] phoneList();
	public CellPhone[] cellphoneList();
	public Iphone[] iphoneList();
	public GalaxyNote[] GalaxynoteList();

	public Iphone detail(Iphpne iphone);
	public GalaxyNote detail(GalaxyNote galaxynote);

	public int count();

	public void update(Phone phone);
	public void update(cellPhone cellphone);
	public void update(Iphone iphone);
	public void update(GalaxyNote galaxynote);

	public void delete(Phone phone);
	public void delete(cellPhone cellphone);
	public void delete(Iphone iphone);
	public void delete(GalaxyNote galaxynote);
	
	public String printphone();
	public String printcell();
	public String printiphone();
	public String printgalaxy();
}
