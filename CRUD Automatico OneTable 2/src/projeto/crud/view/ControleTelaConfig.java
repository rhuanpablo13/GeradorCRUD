package projeto.crud.view;

import java.sql.Connection;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.crud.MainApp;
import projeto.crud.constantes.Const;
import projeto.crud.database.connection.ConnectionSingleton;
import projeto.crud.database.controle.MetadadosDatabase;
import projeto.crud.io.IOExcel;
import projeto.crud.model.Banco;
import projeto.crud.utils.PopUpDiretorioUtils;
import projeto.crud.utils.PopUpAlertUtils;
import projeto.crud.utils.ValidaCamposUtils;


public class ControleTelaConfig {

	@FXML
	private TextField urlDiretorio;
	@FXML
	private Label banco = new Label();
	@FXML
	private ComboBox<String> selectTable;




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
		MainApp.getBanco();
		banco.setText(Banco.getBanco()); /**Seta no atributo desta classe o nome do banco*/
		initComboBox();
	}

	@FXML
    private void handleTelaDiretorio() {
		if(!(ValidaCamposUtils.checkEmptyFields(urlDiretorio))){
			mainApp.getProjeto().setUrlProjeto(urlDiretorio.getText());
			mainApp.getProjeto().setTabela(getSelectedItem());
			mainApp.getProjeto().gravarTabelaEmArquivoXLS();
			if(isUniquePrimaryKey())
			    mainApp.getProjeto().criarModelBean();
			else{
				PopUpAlertUtils.getWarning("Erro", "Tabela selecionada inválida!", "Esta tabela"
						 + " possui relacionamento, por favor selecione uma tabela SEM RELACIONAMENTOS!");
			}
		}else{
			PopUpAlertUtils.getWarning("Erro", "Há campos inválidos!", "Por favor, verifique"
									 + " se todos os campos estão preenchidos ou selecionados!");
        }
	}



	/**
	 * Método que chama a classe (Diretorio) que é responsavel por criar
	 * uma janela auxiliar para seleção de diretórios!
	 */
	@FXML
    private void selecionaDiretorio(){
    	PopUpDiretorioUtils diretorio = new PopUpDiretorioUtils();
    	diretorio.start(new Stage());
    	urlDiretorio.setText(diretorio.getPath());
    }



	/**
	 * Adiciona as tabelas do banco de dados no combobox
	 */
	public void initComboBox(){
		MetadadosDatabase meta = new MetadadosDatabase(getConnection());
		List<String> tabelas = meta.getTabelas();
		if(tabelas.size() == 0){
			PopUpAlertUtils.getWarning("Erro", "Não há tabelas neste banco!",
									   "O banco de dados: " + banco + " não possui tabelas!");
			return;
		}
		selectTable.getItems().addAll(tabelas);
		selectTable.setValue(tabelas.get(0));
	}



	/**
	 * Método que recupera uma conexão com o banco de dados
	 * @return
	 */
	private Connection getConnection(){
		ConnectionSingleton cs = ConnectionSingleton.getInstance();
		return cs.getConnection();
	}



	/**
	 * Retorna o item selectionado do ComboBox
	 * @return String
	 */
	private String getSelectedItem(){
		return selectTable.getValue();
	}



	/**
	 * Método que verifica se a tabela selecionada pelo usuário
	 * só possui uma chave primária, ao contrário , se houver
	 * mais de uma chave, a tabela possui relacionamentos
	 * @return boolean
	 */
	private boolean isUniquePrimaryKey(){
		if(IOExcel.lerColuna(Const.PK, 1).size() > 1){
			return false;
		}
		return true;
	}
}
