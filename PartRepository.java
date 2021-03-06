import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.function.Predicate;
public class PartRepository extends UnicastRemoteObject implements Interfacermi {
	private static final long serialVersionUID = -893491036037807711L;
	public List<Part> partList = new ArrayList<>();
    protected PartRepository() throws RemoteException {
        super();
    }
    protected PartRepository(List<Part> list) throws RemoteException {
        super();
        this.partList = list;
    }
    public void addPart(Part part) throws RemoteException{
    	partList.add(part);
    	System.out.println("Part adicionada com sucesso");
    }
    
    public Part acharPart(Part part) throws RemoteException {
        Predicate<Part> predicate = x -> x.getCodPeca().equals(part.getCodPeca());
        return partList.stream().filter(predicate).findFirst().get();
    }
    
    public List<Part> todasPart() throws RemoteException {
        return partList;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind(args[0], new PartRepository());
            System.err.println("Server pronto");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

}
