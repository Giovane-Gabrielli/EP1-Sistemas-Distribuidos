//Essa é a classe que representa a "Leaf", seguindo o padrão de projeto "Composite":
//Uma Peça primitiva que não é formada por um conjunto de peças.
public class PecaPrimitiva extends Part{
	//construtor para peça primitiva:
	public PecaPrimitiva (int codPeca, String nome, String descricao){
		this.codPeca = codPeca;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}