import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;
public class Client {
	private static Interfacermi look_up;
	private static Part parteatual;
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		//boolean continuar;
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
				System.out.println("Codigo da peça desejada?");
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
				
				
			}
			
		}
	        /*do {

	            String[] options = {"Show All", "Find a book", "Exit"};

	            int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Option dialog",
	                    JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.INFORMATION_MESSAGE,
	                    null, options, options[0]);

	            switch (choice) {

	                case 0:
	                    List<Book> list = look_up.allBooks();
	                    StringBuilder message = new StringBuilder();
	                    list.forEach(x -> {
	                        message.append(x.toString() + "\n");
	                    });
	                    JOptionPane.showMessageDialog(null, new String(message));
	                    break;
	                case 1:
	                    String isbn = JOptionPane.showInputDialog("Type the isbn of the book you want to find.");
	                    try {
	                        Book response = look_up.findBook(new Book(isbn));
	                        JOptionPane.showMessageDialog(null, "Title: " +
	                                        response.getTitle() + "\n" + "Cost: $" +
	                                        response.getCost(),
	                                response.getIsbn(), JOptionPane.INFORMATION_MESSAGE);
	                    } catch (NoSuchElementException ex) {
	                        JOptionPane.showMessageDialog(null, "Not found");
	                    }
	                    break;
	                default:
	                    System.exit(0);
	                    break;

	            }
	            findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit",
	                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
	        } while (findmore);
	    }*/
	    }
}
	    