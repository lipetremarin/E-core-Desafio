package src;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	//Lista de Objetos do tipo Pessoa para armazenar os inputs
	static List<Pessoa> Pessoas = new ArrayList<Pessoa>();
	//Objeto do tipo scanner para receber os inputs do usuario
	static Scanner sc = new Scanner(System.in);
	static int idade;

	//Metodo main para gerenciar as ações 
	public static void main(String[] args) {
		
		//iniciando o sistema com o primeiro cadastro
		System.out.println("Comece o armazenamento de dados cadastrais de pessoas");
		System.out.println("Para o primeiro cadastro por favor digite o nome da pessoa");
		
		//utiliza o metodo scanner para ler input da tela e armazenar na variavel nome
		String nome = sc.nextLine();
		
		//garante que a idade seja maior do que 0
		do {
			
			System.out.println("Agora digite a idade da pessoa por favor (Numeros positivos apenas)");
			//utiliza o metodo scanner para ler input da tela e armazenar na variavel idade
			idade = sc.nextInt();
			
		} while (idade<0);
		
		//adiciona uma nova instancia do objeto Pessoa dentro da lista de pessoas
		Pessoas.add(new Pessoa(nome, idade));
		System.out.println("Cadastro completo");
		
		//inicializando variavel choice que representa a escolha a partir do menu
		int choice = 0;
		
		//loop do menu que continua enquanto a opção 4 não for escolhida
		while(choice != 4) {
			//loop para confirmar que uma opção valida seja escolhida
			do {
				
				menu();
				choice = sc.nextInt();
				
			}while(choice<0 && choice>4);
			
			/*se opção 1 chama adiciona um registro de uma pessoa
			  se opção 2 exibe todas as pessoas cadsatradas
			  se opção 3 exibe todas as pessoas cadastradas por categoria
			*/
			if(choice == 1) {
				
				adicionarPessoa();
				
			}else if(choice == 2) {
				
				exibirCadastros();
				
			}else if(choice == 3) {
				
				exibirCategoria();
				
			}
		}
		
		System.out.println("Obrigado por usar nosso sistema de cadastro");
		sc.close();
		
	}
	
	
	//metodo para imprimir as opções na tela
	public static void menu() {
		
		System.out.println(
		"\nMenu de Ações:(Digite o numero referente a ação desejada)\n"+
		"1- Adicionar Cadastro\n"+
		"2- Exibir Pessoas Cadastradas\n"+
		"3- Exibir cadastros por categoria\n"
		+ "4- Sair\n"
		);
		
	}
	
	//metodo usado para adicionar uma pessoa aos registros
	public static void adicionarPessoa() {
		
		int idade;
		
		System.out.println("Por favor digite o nome da pessoa");
		sc.nextLine();
		String nome = sc.nextLine();
		
		//confirma que a idade é maior que 0
		do {
			
			System.out.println("\nAgora digite a idade da pessoa(Obrigatorio maior que 0)");
			idade = sc.nextInt();
			
		} while (idade<0);
		
		Pessoas.add(new Pessoa(nome, idade));
		System.out.println("\nCadastro completo");
		
	}
	
	//exibe todas as pessoas cadastradas
	public static void exibirCadastros() {
		
		//ordena primeiro por nome depois por idade para que as pessoas que tenham a mesma idade sejam ordenadas por ordem alfabetica
		Pessoas.sort(Comparator.comparing(Pessoa::getNome));
		Pessoas.sort(Comparator.comparing(Pessoa::getIdade));
		
		//itera pelos registros e imprime eles na tela
		for(int i = 0; i<Pessoas.size(); i++) {
			
			System.out.println(Pessoas.get(i).toString()+ "\n");
			
		}
	}
	
	//imprime os registros a partir das categorias
	public static void exibirCategoria() {
		
		//ordena primeiro por nome depois por idade para que as pessoas que tenham a mesma idade sejam ordenadas por ordem alfabetica
		Pessoas.sort(Comparator.comparing(Pessoa::getNome));
		Pessoas.sort(Comparator.comparing(Pessoa::getIdade));
		
		//cria uma lista temporaria dos registros
		List<Pessoa> temp = Pessoas;
		
		System.out.println("Categoria: \n\nCriança\n");
		
		//imprime os registros que tenham categoria criança e apaga da lista para que as proximas iterações não precisem iterar de novo por essas
		for(int i = 0; i<temp.size(); i++) {
			
			if(temp.get(i).getCategory() == "Criança") {
				
				System.out.println(temp.get(i).toString()+ "\n");
				temp.remove(i);
				
			}
		}
		
		System.out.println("\nAdolescente:\n");
		
		//imprime os registros que tenham categoria adolescente e apaga da lista
		for(int i = 0; i<temp.size(); i++) {
			if(temp.get(i).getCategory() == "Adolescente") {
				System.out.println(temp.get(i).toString()+ "\n");
				temp.remove(i);
			}
		}
		
		System.out.println("\nAdulto:\n");
		
		//imprime os registros que tenham categoria adulto e apaga da lista
		for(int i = 0; i<temp.size(); i++) {
			if(temp.get(i).getCategory() == "Adulto") {
				System.out.println(temp.get(i).toString()+ "\n");
				temp.remove(i);
			}
		}
		
		System.out.println("\nIdoso:\n");
		
		//imprime os registros que sobraram por todos terem a categoria que sobrou
		for(int i = 0; i<temp.size(); i++) {
			
			System.out.println(temp.get(i).toString()+ "\n");
			
		}
	}

}
