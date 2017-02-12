package projeto.crud.gerador.connection;
import projeto.crud.constantes.Const;
import projeto.crud.gerador.Gerador;
import projeto.crud.model.Banco;


public abstract class GeradorConnection extends Gerador{

	protected Banco banco;


	public GeradorConnection() {
		// TODO Auto-generated constructor stub
	}

	public GeradorConnection(Banco banco) {
		// TODO Auto-generated constructor stub
		this.banco = banco;
	}


	/**
	 * Troca o marcador #LOCALHOST
	 */
	protected void setLocalHost(){
		trocaCampo(Const.SUBSTITUIR_ARQ_CONN_LOCALHOST, Banco.getHost());
	}


	/**
	 * Troca o marcador #BANCO
	 */
	protected void setBanco(){
		trocaCampo(Const.SUBSTITUIR_ARQ_CONN_BANCO, Banco.getBanco());
	}


	/**
	 * Troca o marcador #USUARIO
	 */
	protected void setUsuario(){
		trocaCampo(Const.SUBSTITUIR_ARQ_CONN_USUARIO, Banco.getUsuario());
	}


	/**
	 * Troca o marcador #SENHA
	 */
	protected void setSenha(){
		trocaCampo(Const.SUBSTITUIR_ARQ_CONN_SENHA, Banco.getSenha());
	}

}
