package lab10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreatePlates extends UnicastRemoteObject implements CarInterface {

	public CreatePlates() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String registration(Car car) throws RemoteException {
		return " " + car.hashCode();
	}
	
}
