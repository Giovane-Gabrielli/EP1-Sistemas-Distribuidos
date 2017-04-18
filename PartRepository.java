//interface que representa um repositório de peças, deve extender "Remote";
import java.util.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
public abstract class PartRepository extends Remote{
	//metodo de inserir peças ao repositorio:
	public void inserePeca throws RemoteException(String nome, String descricao, int[] sub){
	}

}
