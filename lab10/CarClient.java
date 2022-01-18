package lab10;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class CarClient {

	   public static void main(String[] args) throws java.rmi.RemoteException, MalformedURLException, NotBoundException {
		   LocateRegistry.getRegistry("1099");
		  Car[] cars = new Car[3];
	      cars[0] = new Car("Ferrari", "Red", 2000);
	      cars[1] = new Car("Hummer H3", "Black", 1000);
	      cars[2] = new Car("Audi R8", "Blue", 3000);

	      for (int i = 0; i < 3; i++) {
	          System.out.println("Register Request   >\n" +
	        	cars[i].toString());
	      

	          try {
	             CarInterface stub = (CarInterface) Naming.lookup("rmi://localhost:1099/CreatePlate"); 
	             cars[i].setPlate(stub.registration(cars[i])); 
	             System.out.println("Register Response:\n"
	+ cars[i].toString()+ "\n");

	          } catch (Throwable throwable) {
	             System.out.println("Exception Message: " + 
	throwable.getMessage());
	          }
	      }


	      System.out.println("***Register Request Clear!***");
	   }
}
