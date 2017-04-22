//classe abstrata Part que representa uma peça;
import java.io.Serializable;
import java.util.*;
public class Part implements Serializable{
	private static final long serialVersionUID = -1627664726140243393L; //serial de classe gerado automaticamente pra evitar conflitos futuros
	public String codPeca; // Código da peça, gerado automaticamente pelo sistema;	
	public String nome; // Nome da peça;
	public String descricao; // Descrição da peça;
	public List<Part> subpart = new ArrayList<>();
	public Part(String codigo){
		this.codPeca = codigo;
	}
	public Part(String codigo, String nome, String descricao){
		this.codPeca = codigo;
		this.nome=nome;
		this.descricao=descricao;
	}
	//geters:
	public String getCodPeca(){
		return this.codPeca;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	public String toString() {
	    return "> " + this.codPeca + " " + this.nome + ": " + this.descricao;
	}
	
	
}
