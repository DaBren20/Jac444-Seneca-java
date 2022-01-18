package lab10;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote {
	public String registration(Car car) throws RemoteException;
}
