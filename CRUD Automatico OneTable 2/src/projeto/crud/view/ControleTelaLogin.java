package projeto.crud.view;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import projeto.crud.MainApp;
import projeto.crud.constantes.Const;
import projeto.crud.database.SelectDatabaseConnection;
import projeto.crud.database.connection.ConnectionSingleton;
import projeto.crud.model.Banco;
import projeto.crud.utils.PopUpAlertUtils;
import projeto.crud.utils.ValidaCamposUtils;

public class ControleTelaLogin {

	@FXML
	private TextField banco;
	@FXML
	private TextField porta;
	@FXML
	private TextField host;
	@FXML
	private TextField usuario;
	@FXML
	private PasswordField senha;
	@FXML
	private ComboBox<String> selectDatabase;


	//referencia ao mainApp
	private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	 /**
     * Inicializa esta classe controller. Este método é chamado automaticamente
     *  após o arquivo fxml ter sido carregado.
     */
	@FXML
	private void initialize(){
		initComboBox();
		setValues();
	}

	private void setValues(){
		banco.setText("projeto");
		porta.setText("3306");
		host.setText("localhost");
		usuario.setText("root");
		senha.setText("root");
	}

	/**
	* Método da tela de login
	*/
	@FXML
    private void handleTelaLogin() {

		/**Valida campos vazios*/
		if(!(ValidaCamposUtils.checkEmptyFields(banco, porta, usuario, host))){
			setAtributos(); /**Seta os valores na classe Banco, passados pelo usuário*/
			SelectDatabaseConnection.getDatabase(getSelectedItem()); /**Seleciona o banco (polimorfismo) e manda a conexão adequada para a ConnectionSingleton*/
			if(ConnectionSingleton.getInstance() != null){
					mainApp.showTelaConfig();
			}else{
				PopUpAlertUtils.getWarning("Erro de Conexão", "Erro de Conexão!", "Por favor, verifique se todos os campos estão corretos!");
			}
		}else{
				PopUpAlertUtils.getWarning("Erro", "Campos incorretos!", "Por favor, verifique se todos os campos estão corretos!");
		}
	}



	/**
	 * Seta os atributos passados pelo usuario, no modelo banco, na classe mainApp
	 */
	private void setAtributos(){
		Banco.setBanco(banco.getText());
		Banco.setPorta(porta.getText());
		Banco.setHost(host.getText());
		Banco.setUsuario(usuario.getText());
		Banco.setSenha(senha.getText());
	}



	/**
	 * Adiciona os bancos no combobox
	 */
	public void initComboBox(){
		selectDatabase.getItems().addAll(
                Const._ORACLE,
                Const._MYSQL,
                Const._SQLSERVER,
                Const._HSQLDB
            );
		selectDatabase.setValue(Const._MYSQL);
	}



	/**
	 * Retorna o item selectionado do ComboBox
	 * @return String
	 */
	private String getSelectedItem(){
		return selectDatabase.getValue();
	}

}
