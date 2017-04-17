//classe abstrata Part que representa uma peça;
public abstract class Part{
	public int codPeca; // Código da peça, gerado automaticamente pelo sistema;
	public String nome; // Nome da peça;
	public String descricao; // Descrição da peça;
	public int[] sub = new int[2];  //lista de subcomponentes da peça (subPart, quantidade) - subPart pode conter apenas o identificador da subpeça;
	
	//geters:
	public int getCodPeca(){
		return this.codPeca;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	
}
