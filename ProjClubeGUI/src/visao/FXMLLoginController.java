package visao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dominio.Socio;
import persistencia.SocioDAO;

public class FXMLLoginController implements Initializable {

    @FXML
    private AnchorPane apnLogin, apnSocio, apnRelatorio;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private TextField txtLogin, txtId, txtNome, txtCelular;
    @FXML
    private Button btnOK, btnSair, btnIncluirAlterar, btnVoltar, btnBuscar, btnExcluir, btnRelatorio, btnVoltarRelat;
    @FXML
    private Label lblMensagem;
    @FXML
    private TableView<Socio> tbvRelatorio;
    @FXML
    private TableColumn<Socio, Integer> tbcID;
    @FXML
    private TableColumn<Socio, String> tbcNome;
    @FXML
    private TableColumn<Socio, String> tbcCelular;
    @FXML
    private ComboBox<String> cbxNomes;
    
    Socio s;
    SocioDAO sDAO = new SocioDAO();
    int op; //0 - Tela Inicial, 1 - Inclusão, 2 - Alteração
    Alert alert = new Alert(AlertType.CONFIRMATION);

    // listas para preencher os componentes da tela que mostraram os dados
    private ObservableList<Socio> socios = FXCollections.observableArrayList();
    private ObservableList<String> nomesSocios = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       	apnLogin.setVisible(true);
       	apnSocio.setVisible(false);
       	apnRelatorio.setVisible(false);
    }    
    
    @FXML
    private void handleBtnOKAction() {
    	String login = "clubesocio";
    	String senha = "123";
    	if(txtLogin.getText().equals(login) && txtSenha.getText().equals(senha)) {
       		apnLogin.setVisible(false);
       		apnSocio.setVisible(true);
	        op = 0;
	        configurarTela();
    	} else {
	       	txtLogin.setText("");
	       	txtSenha.setText("");
            txtLogin.requestFocus();
    	}
    }
    
    @FXML
    private void handleBtnSairAction() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleBtnVoltarAction() {
    	if(btnVoltar.getText().equals("Voltar")){
	        apnLogin.setVisible(true);
	       	apnSocio.setVisible(false);
	       	txtLogin.setText("");
	       	txtSenha.setText("");
    	} else {
        	op = 0;
        	configurarTela();
    	}
    }
       	
    @FXML
    private void handleBtnBuscarAction() {
    	if(!txtId.getText().equals("")) { //se o id não está vazio
	        txtNome.setEditable(true); 
	        txtCelular.setEditable(true);        	    		
		    s = new Socio();
		    s = sDAO.buscar(Integer.parseInt(txtId.getText()));
		    if(s==null){
		        lblMensagem.setText("Sócio não cadastrado!");
	        	op = 1; // flag - operação de inclusão de sócio
	        	configurarTela();
		    }else{
		        lblMensagem.setText("Sócio localizado");
		        txtNome.setText(s.getNome());
		        txtCelular.setText(s.getCelular());
		        lblMensagem.setText("Sócio cadastrado!");
	        	op = 2; // flag - operação de ALTERAÇÃO/EXCLUSÃO de sócio
	        	configurarTela();
		    }
    	} else {
            txtId.requestFocus();
    	}
    }
    
    @FXML
    private void handleBtIncluirAlterarAction() {
    	s = new Socio();
    	s.setId(Integer.parseInt(txtId.getText()));
    	s.setNome(txtNome.getText());
    	s.setCelular(txtCelular.getText());
    	switch(op) {
	    	case 1: sDAO.inclusao(s);
	    		lblMensagem.setText("Inclusão efetuada com sucesso!");
				break;
	    	case 2: sDAO.alteracao(s, s.getId());
	    		lblMensagem.setText("Alteração efetuada com sucesso!");
				break;
    	}
    	op = 0;
    	configurarTela();
    }
    
    @FXML
    private void handleBtExcluirAction() {
    	alert.setTitle("Caixa de Confirmação");
    	alert.setHeaderText("Exclusão Permanente");
    	alert.setContentText("Tem certeza que deseja excluir o sócio?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // Botão OK
     	    sDAO.exclusao(Integer.parseInt(txtId.getText()));
    		lblMensagem.setText("Exclusão efetuada com sucesso!");
    	} else {
    	    // Botão Cancel
    		lblMensagem.setText("Exclusão cancelada!");
    	}
    	op = 0;
    	configurarTela();
    }
    
    @FXML
    private void handleBtRelatorioAction() {
       	apnSocio.setVisible(false);
    	apnRelatorio.setVisible(true);
	    //populando o ComboBox com os nomes dos contatos
	    nomesSocios.addAll(sDAO.relatorioNomes());
	    cbxNomes.setItems(nomesSocios);
	    // configura a TableColumn, indicando qual atributo da classe irá popular a coluna
	    tbcID.setCellValueFactory(new PropertyValueFactory<>("id")); //nome do atributo
	    tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome")); 
	    tbcCelular.setCellValueFactory(new PropertyValueFactory<>("celular")); 
	    //populando a TableView - inserindo a lista de contatos
	    //pegando do bd: adiciona o retorno da DAO na ObsarvableList
	    socios.addAll(sDAO.relatorio());
	    tbvRelatorio.setItems(socios); 
    }
    
    @FXML
    private void handleBtnVoltaRelatrAction() {
       	apnSocio.setVisible(true);
       	apnRelatorio.setVisible(false);
    }
    
    private void configurarTela() {
    	switch(op) {
	    	case 0: // tela inicial
	            txtId.setEditable(true); 
	            txtNome.setEditable(false); 
	            txtCelular.setEditable(false); 
	            txtId.setText("");
	            txtNome.setText("");
	            txtCelular.setText("");
	            txtId.requestFocus();
	            btnBuscar.setDisable(false);
	            btnIncluirAlterar.setText("Incluir");
	            btnIncluirAlterar.setDisable(true);
	            btnExcluir.setDisable(true);
	            btnVoltar.setText("Voltar");
	            btnVoltar.setDisable(false);
	            btnRelatorio.setDisable(false);
	            lblMensagem.setText("");
	            break;
	    	case 1: // inclusão
	            txtId.setEditable(false); 
	            txtNome.setEditable(true); 
	            txtCelular.setEditable(true); 
	            txtNome.setText("");
	            txtCelular.setText("");
	            txtNome.requestFocus();
	            btnBuscar.setDisable(true);
	            btnIncluirAlterar.setText("Incluir");
	            btnIncluirAlterar.setDisable(false);
	            btnExcluir.setDisable(true);
	            btnVoltar.setText("Cancelar");
	            btnVoltar.setDisable(false);
	            btnRelatorio.setDisable(true);
	            break;
	    	case 2: // alteração ou exclusão
	            txtId.setEditable(false); 
	            txtNome.setEditable(true); 
	            txtCelular.setEditable(true); 
	            txtNome.requestFocus();
	            btnBuscar.setDisable(true);
	            btnIncluirAlterar.setText("Alterar");
	            btnIncluirAlterar.setDisable(false);
	            btnExcluir.setDisable(false);
	            btnVoltar.setText("Cancelar");
	            btnVoltar.setDisable(false);
	            btnRelatorio.setDisable(true);
	            break;
    	}
    }
    
}

