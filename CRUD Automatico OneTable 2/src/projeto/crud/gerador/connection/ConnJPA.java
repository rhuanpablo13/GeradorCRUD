package projeto.crud.gerador.connection;

import projeto.crud.constantes.Const;

public class ConnJPA extends GeradorConnection{


	public ConnJPA() {
		// TODO Auto-generated constructor stub
		buildClass();
	}


	@Override
	protected void buildClass() {
		// TODO Auto-generated method stub
		classeArquivo = carregarArquivo(Const.ARQUIVO_CONN_JPA, Const.DIR_PADRAO_CONEXAO);
		setCabecalho(Const.SUBSTITUIR_ARQ_CONN_CABECALHO, setCabecalho());
		setPacote(Const.SUBSTITUIR_PACOTE_CONN, Const.SUBSTITUTO_PACOTE_CONN);
	}

	@Override
	public String getClasseBuilded() {
		// TODO Auto-generated method stub
		return classeArquivo;
	}


	private String setCabecalho(){
		return "/** Classe de conexão JPA gerada por Crud Automático 1.0 */";
	}
}
