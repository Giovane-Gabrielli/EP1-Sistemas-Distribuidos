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
			Scanner reader = new Scanner(System.in);
			System.out.println("0:listar rmiregistry em localhost 1: Bindsv  2:Listarparts 3:pegarpart 4:addpart 5:Criarpart 6:partatual 7:addsubpart 8:quit");
			String n = reader.nextLine();
			switch(n){
			case "0":
				String[] listadeserv = Naming.list("//localhost/");
				for (String o:listadeserv){
					System.out.println(o);
				}
			case "1":
				try{
					System.out.println("Digite a url do servidor");
					String nomeserv = reader.nextLine();
					look_up = (Interfacermi) Naming.lookup(nomeserv);
				}
				catch(MalformedURLException e){
					System.out.println("Server invalido");
					continue;
				}
				break;
			case "2":
				List<Part> list = look_up.todasPart();
				list.forEach(x->{
					System.out.println(x.toString());
				});
				break;
			case "3":
				System.out.println("Codigo da peca desejada?");
				String cod = reader.nextLine();
				try{
					Part resposta = look_up.acharPart(new Part(cod));
					System.out.println("Peca atual" + resposta.getCodPeca() + " "+ resposta.getNome());
					parteatual = resposta;
				}
				catch (NoSuchElementException fudeu){
					System.out.println("Nao achei sua peca");
					continue;
				}
				break;
			case "4":
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
			case "5":
				String codigopecanova = Integer.toString(ThreadLocalRandom.current().nextInt());
				System.out.println("nome da parte?");
				String nomepecanova = reader.nextLine();
				System.out.println("descricao?");
				String novadescricao = reader.nextLine();
				parteatual = new Part(codigopecanova,nomepecanova,novadescricao);
				System.out.println("Parte atual atualizada");
				break;
			case "6":
				System.out.println("A parte atual e " + parteatual.toString());
				break;
			case "7":
				String codigosubpecanova = Integer.toString(ThreadLocalRandom.current().nextInt());
				System.out.println("nome da parte?");
				String nomesubpecanova = reader.nextLine();
				System.out.println("descricao?");
				String novasubdescricao = reader.nextLine();
				parteatual.subpart.add(new Part(codigosubpecanova,nomesubpecanova,novasubdescricao));
				System.out.println("Sub-parte adicionada em parte atual");
				break;
			case "8":
				System.out.println("Deseja sair s ou n?");
				String cont = reader.nextLine();
				switch(cont){
				case "s":
					continuar = false;
					break;
				default:
					continuar = true;
					break;
				}
				break;
			case "9":
				List<Part> listasub = parteatual.subpart;
				listasub.forEach(x->{
					System.out.println(x.toString());
				});
				break;
			default:
				break;
			
			}
		}while(continuar);			
	}
}
	    
