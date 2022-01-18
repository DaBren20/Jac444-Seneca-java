package lab10;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
	public CarServer() {
		try {
			
			CreatePlates obj = new CreatePlates();
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CreatePlate", obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new CarServer();
		System.out.println("**** Plate creation is running ****");
	}
} 
