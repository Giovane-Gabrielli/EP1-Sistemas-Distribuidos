import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Interfacermi extends Remote {
	Part acharPart(Part part) throws RemoteException;
	List<Part> todasPart() throws RemoteException;
	void addPart (Part part) throws RemoteException;

}
