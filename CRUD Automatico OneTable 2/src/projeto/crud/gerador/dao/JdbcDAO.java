package projeto.crud.gerador.dao;

import projeto.crud.constantes.Const;

public class JdbcDAO extends GeradorDAO{


	@Override
	protected void buildClass() {
		// TODO Auto-generated method stub
		setCabecalho(Const.SUBSTITUIR_ARQ_DAO_CABECALHO, getCabecalho());
		setClasse(Const.SUBSTITUIR_ARQ_DAO_CLASSDAO, passarPrimeiroCaracterParaMaiusculo(getNomeClasse()));
		setPacote(Const.SUBSTITUIR_PACOTE_DAO, Const.SUBSTITUTO_PACOTE_DAO);
		this.substiruirInterfaceDAO();
		this.substiruirConnection();
		this.substiruirImportClasses();
		this.substituirParametro();
		//insert
		this.substituirSqlInsert();
		this.substituirPreparedStatementInsert();
		//find for id
		this.substituirSetTipoBuscaForId();
		this.substituirTipoParametroFindForId();
		this.substituirSqlFindForId();
		this.substituirPreparedStatementFindForId();
		//listar
		this.substituirSqlListar();
		this.substituirPreparedStatementListar();
		//atualizar
		this.substituirSqlAtualizar();
		this.substituirPreparedStatementAtualizar();
		//excluir
		this.substituirSqlExcluir();
		this.substituirPreparedStatementExcluir();
	}

	@Override
	public String getClasseBuilded() {
		// TODO Auto-generated method stub
		return classeArquivo;
	}



	private String getCabecalho(){
		return "/** DAO gerado por CRUD Autom�tico 1.0 */";
	}

}
