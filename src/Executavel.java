import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Executavel {

	public static void main(String[] args) throws IOException, SQLException {
		
		Scanner entrada = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		
		
		System.out.println("Selecione uma opção");
		System.out.println("1-Cadastrar uma nova pessoa");
		System.out.println("2-Consultar uma pessoa");
		System.out.println("3-Excluir uma pessoa");
		
		int op = entrada.nextInt();
		
		if (op == 1) {
			
			System.out.print("Entre com o nome: ");
			pessoa.setNome(entrada.next());
			System.out.print("Entre com o CPF: ");
			pessoa.setCpf(entrada.next());
			System.out.print("Entra com a idade: ");
			pessoa.setIdade(entrada.next());
			
			pessoa.cadastrarPessoa();
		} else if (op == 2 ) {
			System.out.println("Entre com o CPF: ");
			pessoa.setCpf(entrada.next());
			
			System.out.println(pessoa.consultarPessoa());
		} else if (op == 3) {
			System.out.println("Entre com o CPF: ");
			pessoa.setCpf(entrada.next());
			
			pessoa.apagarPessoa();
		}
	
		entrada.close();
		
		
		
	}
	
}
