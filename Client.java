import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Client {
	private static Interfacermi look_up;
	private static Part parteatual;
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
	boolean continuar = true;
		do{
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter a number: ");
			int n = reader.nextInt();
			switch(n){
			case 1:
				try{
					System.out.println("Digite a url do servidor");
					String nomeserv = reader.nextLine();
					look_up = (Interfacermi) Naming.lookup(nomeserv);
				}
				catch(MalformedURLException e){
					System.out.println("Server invalido");
				}
				break;
			case 2:
				List<Part> list = look_up.todasPart();
				list.forEach(x->{
					System.out.println(x.toString());
				});
				break;
			case 3:
				System.out.println("Codigo da peca desejada?");
				String cod = reader.nextLine();
				try{
					Part resposta = look_up.acharPart(new Part(cod));
					System.out.println("Peca atual" + resposta.getCodPeca() + " "+ resposta.getNome());
					parteatual = resposta;
				}
				catch (NoSuchElementException fudeu){
					System.out.println("Nao achei sua peca");
				}
				break;
			case 4:
				System.out.println("Deseja adicionar parte atual?");
				String lel = reader.nextLine();
				switch(lel){
				case "s":
					look_up.addPart(parteatual);
					System.out.println("Parte adicionada");
					break;
				default:
					System.out.println("Parte nao adicionada");
					break;
					
				}
				break;
			case 5:
				String codigopecanova = Integer.toString(ThreadLocalRandom.current().nextInt());
				System.out.println("nome da parte?");
				String nomepecanova = reader.nextLine();
				System.out.println("descricao?");
				String novadescricao = reader.nextLine();
				parteatual = new Part(codigopecanova,nomepecanova,novadescricao);
				System.out.println("Parte atual atualizada");
				break;
			case 6:
				System.out.println("A parte atual e " + parteatual.toString());
				break;
			
			}
			System.out.println("Deseja continuar s ou n?");
			String cont = reader.nextLine();
			if (cont == "s") continuar = true;
			else continuar = false;
		}while(continuar);			
	}
}
	    
