package dominio;

import java.util.ArrayList;
/**
 *
 * @author Alessandra Mendes
 */
public class Socio {
    private int cpf_s;
    private String nome_s;
    private String data_adm;
    
    private ArrayList<Dependente> listaDep;
    
    public Socio(){
        listaDep = new ArrayList<>();
    }
    
    public Socio(int cpf_s, String nome_s, String data_adm){
        this.cpf_s = cpf_s;
        this.nome_s = nome_s;
        this.data_adm = data_adm;
        listaDep = new ArrayList<>();
    }
    
    public int getCpf_s() {
        return cpf_s;
    }

    public void setCpf_s(int cpf_s) {
        this.cpf_s = cpf_s;
    }

    public String getNome_s() {
        return nome_s;
    }

    public void setNome_s(String nome_s) {
        this.nome_s = nome_s;
    }

    public String getData_adm() {
        return data_adm;
    }

    public void setData_adm(String data_adm) {
        this.data_adm = data_adm;
    }  
    
/*    public void incluirDependente(Dependente d){
        listaDep.add(d);
    }
*/    
    public Dependente consultarDependente(int id){
        int i;
        for(i=0; i<listaDep.size(); i++){
            if(listaDep.get(i).getId()==id)
                return listaDep.get(i);
        }
        return null;
    }
    
    public int getTamanhoLista(){
        return listaDep.size();
    }
    
    public Dependente getDependente(int i){
        return listaDep.get(i);
    }
    
    public void setListaDependentes(ArrayList<Dependente> listaDep) {
    	this.listaDep = listaDep;
    }
    
    public ArrayList<Dependente> getListaDependentes(){
    	return listaDep;
    }
}
