/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alessandra Mendes
 */
public class SocioDAO {

    private Conexao minhaConexao; 
    private final String RELATORIO = "select * from \"Socio\"";
    private final String RELATORIONOMES = "select \"nome_s\" from \"Socio\"";
    private final String BUSCAR = "select * from \"Socio\" where \"pk_cpf_s\"=?";
    private final String INCLUIR = "insert into \"Socio\" (\"pk_cpf_s\", \"nome_s\", "
            + "\"data_adm\") values (?, ?, ?)";
    private final String EXCLUIR = "delete from \"Socio\" where \"pk_cpf_s\"=?";
    private final String ALTERAR = "update \"Socio\" set \"pk_cpf_s\"=?, \"nome_s\"=?, "
            + "\"data_adm\"=? where \"pk_cpf_s\"=?";
    
    public SocioDAO(){
        minhaConexao = new Conexao();
    }
    
    public ArrayList<Socio> relatorio(){
        ArrayList<Socio> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = minhaConexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO);
            while(rs.next()){
                Socio s = new Socio(rs.getInt("pk_cpf_s"), rs.getString("nome_s"),
                                    rs.getString("data_adm"));
                lista.add(s);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }

    public ArrayList<String> relatorioPorNome(){
        ArrayList<String> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = minhaConexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIONOMES);
            while(rs.next()){
                lista.add(rs.getString("nome_s"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return lista;
    }
    
    public Socio buscar(int cpf_s){
    	Socio s = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, cpf_s);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                s = new Socio(rs.getInt("pk_cpf_s"),rs.getString("nome_s"),
                        rs.getString("data_adm"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return s;
    }
    
    public void inclusao(Socio s){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, s.getCpf_s());
            instrucao.setString(2, s.getNome_s());
            instrucao.setString(3, s.getData_adm());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
     
    public void exclusao(int cpf_s){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, cpf_s);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public void alteracao(Socio s, int cpf_sAntigo){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setInt(1, s.getCpf_s());
            instrucao.setString(2, s.getNome_s());
            instrucao.setString(3, s.getData_adm());
            instrucao.setInt(4, cpf_sAntigo);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }    
    

}
