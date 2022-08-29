/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Dependente;
import dominio.Socio;

/**
 *
 * @author Alessandra Mendes
 */
public class DependenteDAO {
    private Conexao minhaConexao;
 
    private final String RELATORIO = "select * from \"Dependente\" where \"fk_cpf_s\"=?";
    private final String EXCLUIRCASCATA = "delete from \"Dependente\" where \"fk_cpf_s\"=?";
    private final String INCLUIR = "insert into \"Dependente\" (\"pk_id\", \"nome_d\", "
            + "\"idade\", \"fk_cpf_s\") values (?, ?, ?, ?)";
    private final String ALTERAR = "update \"Dependente\" set \"pk_id\"=?, \"nome_d\"=?, "
            + "\"idade\"=?, \"fk_cpf_s\"=? where \"pk_id\"=?";

    private final String EXCLUIR = "delete from \"Dependente\" where \"pk_id\"=?";
    
    public DependenteDAO(){
        minhaConexao = new Conexao();
    }
    
    public ArrayList<Dependente> buscarDependentesPorSocio(int cpf_s){
        ArrayList<Dependente> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(RELATORIO);
            instrucao.setInt(1, cpf_s);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                Dependente d = new Dependente(rs.getInt("pk_id"),rs.getString("nome_d"),
                		rs.getInt("idade"));
                lista.add(d);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }

    public void exclusaoEmCascata(int cpf_s){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(EXCLUIRCASCATA);
            instrucao.setInt(1, cpf_s);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public void inclusao(Dependente d, int cpf_s){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, d.getId());
            instrucao.setString(2, d.getNome_d());
            instrucao.setInt(3, d.getIdade());
            instrucao.setInt(4, cpf_s);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
     
    public void alteracao(Dependente d, int cpf_s){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setInt(1, d.getId());
            instrucao.setString(2, d.getNome_d());
            instrucao.setInt(3, d.getIdade());
            instrucao.setInt(4, cpf_s);
            instrucao.setInt(5, d.getId());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }

    public void exclusao(Dependente d){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, d.getId());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }

}
