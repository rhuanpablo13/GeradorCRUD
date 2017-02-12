package projeto.crud.gerador.model;

import projeto.crud.constantes.Const;

public class BeanPadrao extends GeradorBean{


	public BeanPadrao() {
		// TODO Auto-generated constructor stub
		classeArquivo = carregarArquivo(Const.ARQUIVO_BEAN_PADRAO,
									    Const.DIR_PADRAO_BEAN);
		atributos     = getColunaArquivoXLS(Const.CAMPOS);
		tipo          = getColunaArquivoXLS(Const.TIPO);
		this.buildClass();
	}



	@Override
	public String getClasseBuilded() {
		// TODO Auto-generated method stub
		return classeArquivo;
	}


	@Override
	protected void buildClass() {
		System.out.println("Construindo a classe...");
		// TODO Auto-generated method stub
		super.setCabecalho(Const.SUBSTITUIR_ARQ_BEAN_CABECALHO, setCabecalho());
		super.setPacote(Const.SUBSTITUIR_PACOTE_BEAN, Const.SUBSTITUTO_PACOTE_BEAN);
		super.setClasse(Const.SUBSTITUIR_ARQ_CLASS, (getNomeClasse()));
		super.setAtributos();
		super.setGetters();
		super.setSetters();

	}

	private String setCabecalho(){
		return "/** Classe Bean gerada por Gerador Automático 1.0 */\n\n";
	}
}
