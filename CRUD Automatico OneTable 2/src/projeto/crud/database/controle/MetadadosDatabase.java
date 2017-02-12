package projeto.crud.database.controle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.crud.constantes.Const;


/**
 * Classe responsável por recuperar todas as tabelas de um banco de dados
 * @author RHUAN
 *
 */
public class MetadadosDatabase {

	private Connection connection;

	public MetadadosDatabase(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}


	/**
	 * Retorna uma lista com os nomes das tabelas do banco
	 * @return List<String>
	 */
	public List<String> getTabelas(){
		List<String> tabelas = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getTables(null, null, "%", null);
			while (result.next()) {
				tabelas.add(result.getString(3));
		    }
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "getTabelas");
		}
		return tabelas;
	}

}
