import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Interfacermi extends Remote {
	Part acharPart(Integer codigo) throws RemoteException;
	List<Part> todasPart() throws RemoteException;
	Boolean addPart (Part p) throws RemoteException;

}
