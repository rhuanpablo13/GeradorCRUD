package projeto.crud.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.crud.MainApp;
import projeto.crud.constantes.Const;
import projeto.crud.database.connection.ConnectionSingleton;
import projeto.crud.database.controle.TabelaArquivo;
import projeto.crud.gerador.Gerador;
import projeto.crud.gerador.connection.ConnMysql;
import projeto.crud.gerador.connection.GeradorConnection;
import projeto.crud.gerador.dao.GeradorDAO;
import projeto.crud.gerador.dao.JdbcDAO;
import projeto.crud.gerador.model.BeanPadrao;
import projeto.crud.gerador.view.GeradorView;
import projeto.crud.gerador.view.ViewConsole;
import projeto.crud.io.IOArquivos;

public class ProjetoConfig {

	private StringProperty urlProjeto = new SimpleStringProperty();
	private StringProperty tabela     = new SimpleStringProperty();



	/**Gravar os dados da tabela no arquivo xls*/
	public void gravarTabelaEmArquivoXLS(){
		TabelaArquivo ba = new TabelaArquivo(tabela.get(), ConnectionSingleton.getInstance().getConnection());
		ba.gravarTabelaEmArquivo();
	}


	public void criarModelBean(){
		BeanPadrao bean = new BeanPadrao();
		String strBean = bean.getClasseBuilded();
		IOArquivos.gravarArquivo(strBean, "bean.txt", Const.PATH_DIRETORIO);

		GeradorConnection conn = new ConnMysql(MainApp.getBanco());
		String strBanco = conn.getClasseBuilded();
		IOArquivos.gravarArquivo(strBanco, "conn.txt", Const.PATH_DIRETORIO);

		GeradorDAO dao = new JdbcDAO();
		String sdao = dao.getClasseBuilded();
		IOArquivos.gravarArquivo(sdao, "dao.txt", Const.PATH_DIRETORIO);

		GeradorView view = new ViewConsole();
		String sview = view.getClasseBuilded();
		IOArquivos.gravarArquivo(sview, "dao.txt", Const.PATH_DIRETORIO);


	}

	public String getUrlProjeto() {
		return urlProjeto.get();
	}
	public void setUrlProjeto(String urlProjeto) {
		this.urlProjeto.set(urlProjeto);
	}
	public StringProperty urlProjeto() {
        return urlProjeto;
    }


	public String getTabela() {
		return tabela.get();
	}
	public void setTabela(String tabela) {
		this.tabela.set(tabela);
	}
	public StringProperty tabela() {
        return tabela;
    }

}
