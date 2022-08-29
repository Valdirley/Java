/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection con;
	
    public Conexao(){
        caminho = "jdbc:postgresql://localhost:5432/BDSocio";
        usuario = "postgres";
        senha = "123";
    }

    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver"); // Carrega o driver
            // Cria a conexão com o PostgreSQL
            con = DriverManager.getConnection(caminho, usuario, senha); 
        }catch(Exception e){
            System.out.println("Erro na conexão: "+e.getMessage());
        }
    }

    public void desconectar(){
        try{
            con.close(); // fecha a conexão com o PostgreSQL
        }catch(Exception e){
            System.out.println("Erro na desconexão: "+e.getMessage());
        }
    }

    public Connection getConexao(){
        return con;
    }
}
