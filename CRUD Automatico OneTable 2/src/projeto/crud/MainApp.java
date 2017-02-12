package projeto.crud;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projeto.crud.io.IOArquivos;
import projeto.crud.model.Banco;
import projeto.crud.model.ProjetoConfig;
import projeto.crud.view.ControleTelaConfig;
import projeto.crud.view.ControleTelaLogin;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private static Banco banco = null; /**atributo estático para ser acessível durante o programa*/
	private ProjetoConfig projeto;



	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CRUD Automático 1.0");
        this.projeto = new ProjetoConfig();
        initRootLayout();
        showTelaLogin();
	}


	/**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Mostra a tela de login dentro do root layout.
     */
    public void showTelaLogin() {
        try {
        	// Carrega o V_TelaLogin.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TelaLogin.fxml"));
            AnchorPane telaLogin = (AnchorPane) loader.load();

            // Define a tela de login  dentro do root layout.
            rootLayout.setCenter(telaLogin);

            // Dá ao controlador acesso ao mainApp
            ControleTelaLogin controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Mostra a tela de direotirio dentro do root layout.
     */
    public void showTelaConfig() {
    	try {
    		// Carrega o V_TelaLogin.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TelaConfig.fxml"));
            AnchorPane telaConfig = (AnchorPane) loader.load();
            rootLayout.setCenter(telaConfig);

            //Dá ao controlador acesso ao mainApp
            ControleTelaConfig controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Banco getBanco() {
		return banco;
	}


	public static void setBanco(Banco banco) {
		MainApp.banco = banco;
	}


	public ProjetoConfig getProjeto() {
		return projeto;
	}


	public void setProjeto(ProjetoConfig projeto) {
		this.projeto = projeto;
	}



}
