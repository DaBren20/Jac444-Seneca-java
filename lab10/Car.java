package lab10;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Car implements Serializable{
	private String model;
	private String colour;
	private int mileage;
	private String plateNo;
	
	Car(String model, String colour, int mileage) {
		this.model = model;
		this.colour = colour;
		this.mileage = mileage;
		this.plateNo = "undefined";
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public void setPlate(String string) {
		this.plateNo = string;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public String getPlate() {
		return this.plateNo;
	}
	
	@Override
	public String toString() {
		return "Model: " + getModel() + "\nColor: " + getColour() + "\nMileage: "
				+ getMileage() + "\nPlate: " + getPlate();
	}
	
}
