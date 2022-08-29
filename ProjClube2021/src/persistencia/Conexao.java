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
	
	public void conectar() { //m�todo para abrir a conex�o com o BD
		try {
			Class.forName("org.postgresql.Driver"); //carregar o driver JDBC
			con = DriverManager.getConnection(caminho, usuario, senha); //abrir a conex�o
			System.out.println("Conex�o efetuada com sucesso");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Conex�o mal sucedida");
		}
	}
	
	public void desconectar() { //m�todo para fechar a conex�o com o BD
		try {
			con.close();
			System.out.println("Conex�o encerrada com sucesso");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Desconex�o mal sucedida");
		}
	}
	
	public Connection getConexao() { //retorna ao chamador a conex�o estabelecida com o BD
		return con;
	}
}
