package projeto.crud.gerador.connection;

import projeto.crud.constantes.Const;
import projeto.crud.model.Banco;

public class ConnMysql extends GeradorConnection{




	public ConnMysql(Banco banco) {
		super(banco);
		classeArquivo = carregarArquivo(Const.ARQUIVO_CONN_MYSQL, Const.DIR_PADRAO_CONEXAO);
		buildClass();
	}

	@Override
	protected void buildClass() {
		// TODO Auto-generated method stub
		setCabecalho(Const.SUBSTITUIR_ARQ_CONN_CABECALHO, getCabecalho());
		setPacote(Const.SUBSTITUIR_PACOTE_CONN, Const.SUBSTITUTO_PACOTE_CONN);
		setBanco();
		setLocalHost();
		setUsuario();
		setSenha();
	}

	@Override
	public String getClasseBuilded() {
		// TODO Auto-generated method stub
		return classeArquivo;
	}

	private String getCabecalho(){
		return "/** Classe de conexão gerada por Crud Automático 1.0 */";
	}

}
