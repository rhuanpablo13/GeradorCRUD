package projeto.crud.gerador.dao;

import java.util.List;

import projeto.crud.constantes.Const;
import projeto.crud.gerador.Gerador;
import projeto.crud.io.IOExcel;

public abstract class GeradorDAO extends Gerador{



	public GeradorDAO() {
		// TODO Auto-generated constructor stub
		classeArquivo = carregarArquivo(Const.ARQUIVO_DAO_MYSQL, Const.DIR_PADRAO_DAO);
		buildClass();
	}





	//////////////////////////////////////////////
	////////////////	INSERIR		//////////////
	//////////////////////////////////////////////

	/**
	 * Método responsável por substiruir o prepared statement Insert
	 */
	protected void substituirPreparedStatementInsert(){
		String ps = "";
		String arrayPs = "";
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		for (int i = 0; i < campos.size(); i++) {
			ps = "ps";
			ps += ".set" + parseTipo(passarPrimeiroCaracterParaMaiusculo(tipos.get(i)));
			ps += "(" + (i+1) + "," + getNomeClasse() + "." + getGettersAtributos(campos.get(i)) + ");\n";
			ps += "\t    ";
			arrayPs += ps;
		}
		trocaCampo(Const.PREPARED_STATEMENT_INSERT_PARAMETROS, arrayPs);
	}

	protected void substituirSqlInsert(){
		String values = "";
		List<String>campos = getColuna(Const.CAMPOS);
		String ultimoCampo = campos.get(campos.size() -1);
		for (int i = 0; i < campos.size(); i++) {
			values = values + "?";
			if(i < (campos.size() -1)){
				values = values + ", ";
			}
		}
		String sql = "INSERT INTO " + getNomeClasse() + "(";
		for (String campo : campos) {
			sql = sql + campo;
			if(!campo.equals(ultimoCampo)){
				sql = sql + ", ";
			}
		}
		sql = sql + ") values (";
		sql = sql + values + ")";
		trocaCampo(Const.INSERT_ADICIONAR_JDBC_MYSQL, sql);
	}

	//////////////////////////////////////////////
	////////////////	EXCLUIR		//////////////
	//////////////////////////////////////////////

	//////////////////////////////////////////////
	////////////////	LISTAR		//////////////
	//////////////////////////////////////////////

	//////////////////////////////////////////////
	////////////////	BUSCAR ID	//////////////
	//////////////////////////////////////////////


	//////////////////////////////////////////////
	//////////////// BUSCAR STRING  //////////////
	//////////////////////////////////////////////



	//////////////////////////////////////////////
	////////////////	INSERIR		//////////////
	//////////////////////////////////////////////

	protected void substituirPreparedStatementExcluir(){
		String pk = IOExcel.lerCelula(Const.PK, 1);
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		int posicao = campos.indexOf(pk);
		String tipo = tipos.get(posicao);

		String ps = "\t\t\tps.set" + passarPrimeiroCaracterParaMaiusculo(parseTipo(tipo)) +
				    "(1, " + getNomeClasse() + "." + getGettersAtributos(pk) + ");";
		trocaCampo(Const.PREPARED_STATEMENT_EXCLUIR_PARAMETROS, ps);

	}


	protected void substituirSqlExcluir(){
		String delete = "DELETE FROM " + getNomeClasse() + " WHERE " + IOExcel.lerCelula(Const.PK, 1) + " = ?";
		trocaCampo(Const.DELETE_EXCLUIR_JDBC_MYSQL, delete);
	}

	protected void substituirPreparedStatementAtualizar(){
		String ps = "";
		String arrayPs = "";
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		for (int i = 0; i < campos.size(); i++) {
			ps = "\t\t\tps";
			ps += ".set" + parseTipo(passarPrimeiroCaracterParaMaiusculo(tipos.get(i)));
			ps += "(" + (i+1) + "," + getNomeClasse() + "." + getGettersAtributos(campos.get(i)) + ");\n";
			arrayPs += ps;
		}
		trocaCampo(Const.PREPARED_STATEMENT_ATUALIZAR_PARAMETROS, arrayPs);
	}
	protected void substituirSqlAtualizar(){
		String update = "UPDATE " + getNomeClasse() + " SET ";
		List<String> campos = getColuna(Const.CAMPOS);
		String ultimoCampo = campos.get(campos.size() -1);
		for (String campo : campos) {
			update += campo;
			update += " = ?";
			if(!campo.equals(ultimoCampo)){
				update += ", ";
			}
		}
		update += " WHERE " + IOExcel.lerCelula(Const.PK, 1) + " = ?";
		trocaCampo(Const.UPDATE_ATUALIZAR_JDBC_MYSQL, update);
	}

	protected void substituirPreparedStatementListar(){
		String ps = "";
		String arrayPs = "";
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		for (int i = 0; i < campos.size(); i++) {
			ps = "\t\t\t\t";
			ps += getNomeClasse();
			ps += "." + getSettersAtributos(campos.get(i)) + "(";
			ps += "rs." + "get" + passarPrimeiroCaracterParaMaiusculo(parseTipo(tipos.get(i))) + "(\"" + campos.get(i) + "\"));\n";
			arrayPs += ps;
		}
		trocaCampo(Const.PREPARED_STATEMENT_LIST_PARAMETROS, arrayPs);
	}

    protected void substituirSqlListar(){
    	String sql = "SELECT * FROM " + getNomeClasse();
    	trocaCampo(Const.SELECT_LISTAR_JDBC_MYSQL, sql);
    }



    protected void substituirTipoParametroFindForId(){
		String pk = IOExcel.lerCelula(Const.PK, 1);
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		int posicao = campos.indexOf(pk);
		String tipo = tipos.get(posicao);
		trocaCampo(Const.SUBSTITUIR_ARQ_DAO_TIPO_ID_FINDFORID, parseTipo(tipo));
	}

	protected void substituirSqlFindForId(){
		String sql = "SELECT  * FROM " + getNomeClasse() + " WHERE " + IOExcel.lerCelula(Const.PK, 1)+ " = ?";
		trocaCampo(Const.SELECT_FINDFORID_JDBC_MYSQL, sql);
	}
	protected void substituirSetTipoBuscaForId(){
		//PS_SET_TIPO_BUSCA_POR_ID
		String pk = IOExcel.lerCelula(Const.PK, 1);
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		int posicao = campos.indexOf(pk);
		String tipo = tipos.get(posicao);

		String ps = "ps.set" + passarPrimeiroCaracterParaMaiusculo(parseTipo(tipo)) +
				    "(1, id);";
		trocaCampo(Const.SUBSTITUIR_ARQ_DAO_PS_SET_TIPO_BUSCA_POR_ID, ps);
	}
	protected void substituirPreparedStatementFindForId(){
		String ps = "";
		String arrayPs = "";
		List<String>campos = getColuna(Const.CAMPOS);
		List<String>tipos = getColuna(Const.TIPO);
		for (int i = 0; i < campos.size(); i++) {
			ps = "\t\t\t\t";
			ps += getNomeClasse();
			ps += "." + getSettersAtributos(campos.get(i)) + "(";
			ps += "rs." + "get" + passarPrimeiroCaracterParaMaiusculo(parseTipo(tipos.get(i))) + "(\"" + campos.get(i) + "\"));\n";
			arrayPs += ps;
		}
		trocaCampo(Const.PREPARED_STATEMENT_FINDFORID_PARAMETROS, arrayPs);
	}
	///////////////////////////////////////////////////////////





	protected void substituirParametro(){
		trocaCampo(Const.SUBSTITUIR_ARQ_PARAMETRO, getNomeClasse());
	}


	protected void substiruirImportClasses(){
		trocaCampo(Const.SUBSTITUIR_ARQ_DAO_CLASSES_IMPORTS, Const.SUBSTITUTO_ARQ_DAO_CLASSES_IMPORTS);
	}

	protected void substiruirConnection(){
		trocaCampo(Const.SUBSTITUIR_PACOTE_CONNECTION_SINGLETON, Const.SUBSTITUTO_PACOTE_CONNECTION_SINGLETON);
	}

	protected void substiruirInterfaceDAO(){
		trocaCampo(Const.SUBSTITUIR_PACOTE_DAO_INTERFACE, Const.SUBSTITUTO_PACOTE_DAO_INTERFACE);
	}



}
