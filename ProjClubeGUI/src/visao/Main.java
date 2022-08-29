package visao;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage stagePrincipal) throws Exception {
        //Cria um objeto de Parent a partir de um FXML
        //Parent é uma classe base para todo nó que tem nós filhos
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene scene = new Scene(root); //Cria um objeto Scene usando o Parent criado anteriormente
        stagePrincipal.setScene(scene); //Seta a cena no Stage
        stagePrincipal.setTitle("Clube Sócios Amigos SA - Login"); //tÃ­tulo da janela
        stagePrincipal.show(); //Mostra a cena
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
