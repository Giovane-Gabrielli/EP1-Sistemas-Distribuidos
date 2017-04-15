//Essa é a classe que representa a "Component", seguindo o padrão de projeto "Composite":
public abstract class Part{
	public int codPeca; // Código da peça, gerado automaticamente pelo sistema;
	public String nome; // Nome da peça;
	public String descricao; // Descrição da peça;
	public Part  //lista de subcomponentes da peça (subPart, quantidade);
	//Como fazer essa lista de subcomponentes?? já que subPart seria um objeto e quantidade seria um int???
	
	//metodo abstrato para adicionar uma peça:
	public void adicionarPeca(Part peca){
	}
	
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