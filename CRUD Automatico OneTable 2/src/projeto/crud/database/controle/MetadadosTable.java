package projeto.crud.database.controle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.crud.constantes.Const;



/**
 * Classe responsável por recuperar informações sobre uma tabela,
 * por exemplo:
 * - nome das colunas
 * - campos nulos
 * - chaves primárias
 * - tipo do dado
 * - etc...
 *
 * @author RHUAN
 *
 */

class MetadadosTable {

	private Connection connection;
	private String tabela;


	public MetadadosTable(String tabela, Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		this.tabela = tabela;
	}






	/**
	 * Método que retorna o nome das colunas de uma tabela
	 * @param  O nome da tabela
	 * @return List<String>
	 */
	public List<String> getNomeColunas(){
		List<String> colunas = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getColumns(null, null, tabela, null);
			while(result.next()){
				colunas.add(result.getString("COLUMN_NAME"));
			}
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "getName" + Const.NA_TABELA + tabela );
		}
		return colunas;
	}




	/**
	 * Método que retorna o tamanho dos atributos de uma tabela
	 * @param nome da tabela
	 * @return List<String>
	 */
	public List<String> getSize(){
		List<String> size = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getColumns(null, null, tabela, null);
			while (result.next()) {
		    	size.add(result.getString("COLUMN_SIZE"));
		    }
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "getSize" + Const.NA_TABELA + tabela );
		}
		return size;
	}


	/**
	 * Método que recupera os campos nulos da tabela
	 * @param  nome da tabela
	 * @return List<String>
	*/
	public List<String> isNull(){
		List<String> isNull = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getColumns(null, null, tabela, null);
			while(result.next()){
				int nullable = result.getInt("NULLABLE");
				if ((nullable == DatabaseMetaData.columnNullable) ? (isNull.add("Null")) : (isNull.add("Not Null")));
			}
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "isNull" + Const.NA_TABELA + tabela );
		}
		return isNull;
	}




	/**
	 * Método que retorna o tipo de dado de cada atributo da tabela
	 * @param nome da tabela
	 * @return List<String>
	*/
	public List<String> getType(){
		List<String> type = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getColumns(null, null, tabela, null);
			while(result.next()){
			     type.add(result.getString("TYPE_NAME"));
			}
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "getType" + Const.NA_TABELA + tabela );
		}
		return type;
	}


	/**
	 * Método que recupera as chaves primárias de uma tabela
	 * @param nome da tabela tabela
	 * @return List<String>
	*/
	public List<String> getPrimaryKey(){
		List<String> columnName = new ArrayList<>();
		DatabaseMetaData metadata;
		ResultSet result;
		try{
			metadata = connection.getMetaData();
			result = metadata.getPrimaryKeys(null, null, tabela);
			while(result.next()){
				columnName.add(result.getString("COLUMN_NAME"));
			}
			result.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(Const.ERRO_EM + "getPrimaryKey" + Const.NA_TABELA + tabela );
		}
		return columnName;
	}











//MÉTODOS QUE SERÃO CORRIGIDOS DEPOIS


//	/**
//	 * Recupera as chaves que est�o sendo importadas para a tabela (chaves estrangeiras)
//	 * @param banco
//	 * @param tabela
//	 * @return List[fk][tabela]
//	 */
//	public List<String> getImportedKeys(){
//		List<String>campos = new ArrayList<>();
//		try {
//			setResult(getDtMetadata().getImportedKeys(getConnection().getCatalog(), null, tabela));
//			campos = getMetadaDado(Constantes._IMPORTED);
//		}catch (Exception e) {
//		      e.printStackTrace();
//		      System.out.println("ERRO EM: getImportedKeys: " + tabela );
//		 }
//		 return campos;
//	}
//
//	/***
//	 * Recupera as chaves que est�o sendo exportadas da tabela
//	 * @param banco
//	 * @param tabela
//	 * @return chaves exportadas ou vazio
//	*/
//	public List<String> getExportedKeys(){
//
//		List<String> campos = new ArrayList<>();
//		try{
//			setResult(getDtMetadata().getExportedKeys(getConnection().getCatalog(), null, tabela));
//			campos = getMetadaDado(Constantes._EXPORTED);
//		}catch(SQLException e){
//			e.printStackTrace();
//			System.out.println("ERRO EM: getExportedKeys: " + tabela);
//		}
//		return campos;
//	}


	/* tabelas getTables(null, null, "%", null));
	 * campos getColumns(null, null, tabela, null));
	 * size getColumns(null, null, tabela, null));
	 * isnull getColumns(null, null, tabela, null));
	 * type getColumns(null, null, tabela, null));
	 *
	 * pk getPrimaryKeys(null, null, tabela));
	 * imported getImportedKeys(getConnection().getCatalog(), null, tabela));
	 * exported getExportedKeys(getConnection().getCatalog(), null, tabela));
	 */


}
