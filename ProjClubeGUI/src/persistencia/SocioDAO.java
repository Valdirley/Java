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
    private final String RELATORIONOMES = "select \"nome\" from \"Socio\"";
    private final String BUSCAR = "select * from \"Socio\" where \"id\"=?";
    private final String INCLUIR = "insert into \"Socio\" (\"id\", \"nome\", "
            + "\"celular\") values (?, ?, ?)";
    private final String EXCLUIR = "delete from \"Socio\" where \"id\"=?";
    private final String ALTERAR = "update \"Socio\" set \"id\"=?, \"nome\"=?, "
            + "\"celular\"=? where \"id\"=?";
    
    public SocioDAO(){
        minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/DBClube",
                "postgres","123");
    }
    
    public ArrayList<Socio> relatorio(){
        ArrayList<Socio> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = minhaConexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO);
            while(rs.next()){
                Socio s = new Socio(rs.getInt("id"), rs.getString("nome"),
                                    rs.getString("celular"));
                lista.add(s);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }

    public ArrayList<String> relatorioNomes(){
        ArrayList<String> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = minhaConexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIONOMES);
            while(rs.next()){
                lista.add(rs.getString("nome"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return lista;
    }
    
    public Socio buscar(int id){
    	Socio s = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                s = new Socio(rs.getInt("id"),rs.getString("nome"),
                        rs.getString("celular"));
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
            instrucao.setInt(1, s.getId());
            instrucao.setString(2, s.getNome());
            instrucao.setString(3, s.getCelular());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
     
    public void exclusao(int id){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, id);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public void alteracao(Socio s, int idAntigo){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao = 
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setInt(1, s.getId());
            instrucao.setString(2, s.getNome());
            instrucao.setString(3, s.getCelular());
            instrucao.setInt(4, idAntigo);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }    
        
}
