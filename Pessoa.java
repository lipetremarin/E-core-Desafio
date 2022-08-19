package src;

public class Pessoa {
	
	String nome, category;
	int idade;
	
	//recebe os parametros nome e idade e a partir da idade define a categoria do mesmo
	public Pessoa(String nome, int idade) {
		this.nome  = nome;
		this.idade = idade;
		
		if(idade <= 12){
			category = "Criança";
		}
		else if (idade>12 && idade <= 19){
			category = "Adolescente";
		}
		else if (idade>19 && idade <= 65){
			category = "Adulto";
		}
		else{
			category = "Idoso";
		}
		
	}
	
	//getters and setters
	
	public String getNome(){
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	//toString metodo
	
	@Override
	public String toString() {
		return "Nome:  " + nome + "\nIdade: " + idade + "\nCategoria: " + category;
	}

}
