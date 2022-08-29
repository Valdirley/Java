package persistencia;

import java.sql.*;

public class Conexao {

	private String usuario;
	private String senha;
	private String caminho;
	
	private Connection con;
	
	public Conexao() {
		caminho = "jdbc:postgresql://localhost:5432/BDSocio";
		usuario = "postgres";
		senha = "123";
	}
	
	public void conectar() { //método para abrir a conexão com o BD
		try {
			Class.forName("org.postgresql.Driver"); //carregar o driver JDBC
			con = DriverManager.getConnection(caminho, usuario, senha); //abrir a conexão
			System.out.println("Conexão efetuada com sucesso");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Conexão mal sucedida");
		}
	}
	
	public void desconectar() { //método para fechar a conexão com o BD
		try {
			con.close();
			System.out.println("Conexão encerrada com sucesso");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Desconexão mal sucedida");
		}
	}
	
	public Connection getConexao() { //retorna ao chamador a conexão estabelecida com o BD
		return con;
	}
}
