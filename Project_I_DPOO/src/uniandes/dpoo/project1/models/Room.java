package uniandes.dpoo.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
	//Attributes
	private int id;
	private int fee;
	private String type;
	private int capacity;
	private List<Bed> listBeds;
	private boolean view;
	private boolean kitchen;
	private boolean balcony;
	
	//new attributtes
	Integer size_m2;
	boolean air_conditioner, heating, tv, coffee_maker, dryer, hair_iron;
	boolean ac_voltage, usb_a, usb_c, breakfast;
	
	private List<Guest> listGuests = new ArrayList<>();
	private int auxroominitial;
	private int auxroomfinal;
	
	//constructor
	public Room(int id, String type, int capacity, List<Bed> listBeds, boolean view,
			boolean kitchen, boolean balcony, int size_m2, boolean air_conditioner,
			boolean heating, boolean tv, boolean coffee_maker, boolean dryer,
			boolean hair_iron, boolean ac_voltage, boolean usb_a,
			boolean usb_c, boolean breakfast) {
		this.id = id;
		this.type = type;
		this.capacity = capacity;
		this.listBeds = listBeds;
		this.view = view;
		this.kitchen = kitchen;
		this.balcony = balcony;
		
		//new attributtes
		this.size_m2 = size_m2;
		this.air_conditioner = air_conditioner;
		this.heating = heating;
		this.tv = tv;
		this.coffee_maker = coffee_maker;
		this.dryer = dryer;
		this.hair_iron = hair_iron;
		this.ac_voltage = ac_voltage;
		this.usb_a = usb_a;
		this.usb_c = usb_c;
		this.breakfast = breakfast;
	}
	
	//setters
	public void addFee() {
		//TO DO
	}
	public void addGuest(Guest newguest) {
		listGuests.add(newguest);
	}
	
	//getters
	public int getRoomPrice() {
		//TO DOOOOOO
		int price = 0;
		return price;
	}
	
	public Integer getM2() {
		return size_m2;
	}
	
	public List<Guest> getGuests(){
		return listGuests;
	}
	
	public int getId() {
		return id;
	}
	public List<Bed> getBeds() {
		return listBeds;
	}
	public boolean getView() {
		return view;
	}
	public boolean getKitchen() {
		return kitchen;
	}
	public boolean getBalcony() {
		return balcony;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getType() {
		return type;
	}
	public int getFee() {
		return fee;
	}

	public void setnumguest(int auxroominitial1, int auxroomfinal1) {
		auxroominitial = auxroominitial1;
		auxroomfinal = auxroomfinal1;
	}
	public int getauxroominitial() {
		return auxroominitial;
	}
	public int getauxroomfinal() {
		return auxroomfinal;
	}
	public boolean getAdvancedCharacteristic(String valueName) {
	        switch (valueName) {
	            case "air_conditioner":
	                return air_conditioner;
	            case "heating":
	                return heating;
	            case "tv":
	                return tv;
	            case "coffee_maker":
	                return coffee_maker;
	            case "dryer":
	                return dryer;
	            case "hair_iron":
	                return hair_iron;
	            case "ac_voltage":
	                return ac_voltage;
	            case "usb_a":
	                return usb_a;
	            case "usb_c":
	                return usb_c;
	            case "breakfast":
	                return breakfast;
	            default:
	                throw new IllegalArgumentException("Invalid valueName: " + valueName);
	        }
	}
}
