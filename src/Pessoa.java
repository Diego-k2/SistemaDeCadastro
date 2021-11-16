import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String idade;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	Pessoa(){};
	
	Pessoa(String nome, String cpf, String idade){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public void cadastrarPessoa() throws IOException, SQLException {
		
		Connection conexao = AbreConexao.abrirConexao();
		
		
		if (nome != null && cpf != null && idade != null ) {
			try {
			String sql = "INSERT INTO pessoa (nome, cpf, idade) VALUES (? , ?, ?);";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, cpf);
			stmt.setString(3, idade);			
			stmt.execute();
			
			System.out.println("Cadastro efetuado!!!");
			} catch (SQLException e) {
				System.out.println("Cadastro não efetuado por conter informações incorretas e/ou repetidas");
			}
		}	
		
	}
	
	public String consultarPessoa() throws SQLException {
		
		Connection conexao = AbreConexao.abrirConexao();
		
		if(cpf != null){
			
			String sql = "SELECT * FROM pessoa WHERE cpf LIKE ?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, "%" + cpf + "%");
			
			ResultSet resultado = stmt.executeQuery();
			 
			List <Pessoa> pessoas = new ArrayList<>();
			
			while (resultado.next()) {
			
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String idade = resultado.getString("idade");
				pessoas.add(new Pessoa(nome, cpf, idade));
				
			}
			
			for(Pessoa p: pessoas) {
				return "|" + p.nome + "|" + "|" + p.cpf + "|" + "|" + p.idade + "|";
			}
		
			
		}
		
		return null;
	}
	
	public void apagarPessoa() throws SQLException {
		
		Connection conexao = AbreConexao.abrirConexao();
		
		if(cpf != null) {
			
			String sql = "DELETE FROM pessoa WHERE cpf LIKE ?;";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			
			
			System.out.println("Dado excluido com sucesso");
		} 
		
	}
	
	
}






























